package MUA.semester1.s1.s4

import java.io.BufferedReader
import java.io.InputStreamReader

object CountSubstrings

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val n = br.readLine().toInt()
        var number = br.readLine()L
        var numberOfOnes = 0

        for (j in 0 until n){
            val digit = number % 10
            if (digit == 1L){
                numberOfOnes ++
            }
            number /= 10
        }

        println((numberOfOnes*(numberOfOnes + 1))/2)
    }
}