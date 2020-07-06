package algorithms

import java.math.BigInteger

object Memoization {

    fun <A, B> memo (f: (A) -> B): (A) -> B {
        val resMap = HashMap<A, B>()
        return {a: A -> resMap.getOrPut(a){ f(a) } }
    }

    val fib: (Int) -> BigInteger by lazy {
        memo { n: Int -> when(n) {
            0 -> 0.toBigInteger()
            1 -> 1.toBigInteger()
            else -> fib(n - 1) + fib(n - 2)
        } }
    }
    

    fun main() {
        println(fib(1000))
    }

}

fun main() {
    Memoization.main()
}
