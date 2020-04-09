package FacebookTest2020

import java.lang.IllegalStateException
import java.util.*

enum class OperatorKind {
    PRODUCT,
    SUM,
    SUBSTRACTION,
}

sealed class Operation() {
    abstract fun addChild(operation: Operation): Operation

    override fun toString(): String = when(this) {
        is Operand -> this.value.toString()
        is Operator -> "(${this.leftOperand} ${Calculator.stringFromKind(this.kind)} ${this.rightOperand})"
    }


    fun solve(): Int = when(this) {
        is Operand -> {
            this.value
        }
        is Operator -> {
            val numericLeft = this.leftOperand?.solve()
            val numericRight = this.rightOperand?.solve()
            when (this.kind) {
                OperatorKind.PRODUCT -> numericLeft!! * numericRight!!
                OperatorKind.SUM -> numericLeft!! + numericRight!!
                OperatorKind.SUBSTRACTION -> if(numericRight == null) numericLeft!! * -1 else numericLeft!! - numericRight
            }
        }
    }

    fun isComplete(): Boolean = when(this) {
        is Operand -> true
        is Operator -> this.leftOperand != null && this.rightOperand != null
    }
    internal class Operand(val value: Int): Operation() {
        override fun addChild(operation: Operation) = throw IllegalStateException("number cannot have children")
    }
    internal class Operator(val kind: OperatorKind, val leftOperand: Operation?, val rightOperand: Operation?): Operation() {
        override fun addChild(operation: Operation): Operation = when {
            this.leftOperand == null -> Operator(this.kind, operation, null)
            this.rightOperand == null -> Operator(this.kind, this.leftOperand, operation)
            else -> throw IllegalAccessException("Cannot add more operands to this operator")
        }
    }

    companion object {
        operator fun invoke(kind: OperatorKind, left: Operation? = null, right: Operation? = null): Operation =
            Operator(kind, left, right)

        operator fun invoke(value: Int): Operation = Operand(value)
    }
}

object Calculator {
    fun kindFromString(op: String): OperatorKind = when (op) {
        "*" -> OperatorKind.PRODUCT
        "+" -> OperatorKind.SUM
        "-" -> OperatorKind.SUBSTRACTION
        else -> throw IllegalArgumentException("The string is not an operator")
    }

    fun stringFromKind(op: OperatorKind): String = when (op) {
        OperatorKind.SUBSTRACTION -> "-"
        OperatorKind.SUM -> "+"
        OperatorKind.PRODUCT -> "*"
    }

    fun operate(expression: List<String>): Int {
        val operatorString = "*+-"
        var operations: Stack<Operation> = Stack()
        for (item in expression) {
            if (operatorString.contains(item)) {
                val op = Operation(kindFromString(item))
                operations.push(op)
            } else {
                val lastOperation = operations.pop()
                val newOperation = lastOperation.addChild(Operation(item.toInt()))
                operations.push(newOperation)

                while (operations.size > 1 && operations.peek().isComplete()) {
                    val operand = operations.pop()
                    val parent = operations.pop()
                    val newParent = parent.addChild(operand)
                    operations.push(newParent)
                }
            }
        }
        val root = operations.pop()
        println(root)
        return root.solve()
    }

    fun solve(expression: String): Int = operate(expression.split(" "))
}

fun main() {
    val s = "+ + 2 + 5 1 + 8 - 5 3;" +
            "- * + 9 4 - 1 5 + 8 5;" +
            "- 1 + * + - 3 1 8 6 1;" +
            "* 1 + * * 1 2 2 5;" +
            "+ - - * 7 7 + 7 7 * 2 4 * 4 * 9 4;" +
            "- + * 1 5 1 + 3 4;" +
            "- * - 2 - 1 - 2 2 * * 3 5 5 * 1 6;" +
            "* 6 * + 1 1 + 8 9;" +
            "+ + + 3 * + 5 2 8 8 + 3 7;" +
            "- - - 5 5 4 - + 6 6 5"
    var ans = ""
    for (eq in s.split(";")){
        ans += "${Calculator.solve(eq)} "
    }
    println(ans.trim())
}