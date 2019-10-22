package MUA.semester1.s1.s3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object Seinfield{

    fun getOpsToStabilize(s: String): Int{

        if(s.length % 2 != 0){
            return 0
        }
        val stack = Stack<Char>()
        var count = 0

        for (c in s){
            if (stack.isEmpty()){
                if (c == '}'){
                    count++
                }
                stack.push('{')
            }else{
                if (c == '}'){
                    stack.pop()
                }else{
                    stack.push(c)
                }
            }
        }

        var leftInStack = 0
        while (stack.isNotEmpty()){
            stack.pop()
            leftInStack ++
        }
        count += leftInStack / 2

        return count
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var s = br.readLine()
    var i = 1
    while (s.get(0) != '-'){
        println(i.toString() + ". " + Seinfield.getOpsToStabilize(s))
        s = br.readLine()
        i++
    }
}