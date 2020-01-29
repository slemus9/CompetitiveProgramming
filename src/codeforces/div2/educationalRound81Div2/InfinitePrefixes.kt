package codeforces.div2.educationalRound81Div2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    for (i in 0 until T){
        val (n, x) = br.readLine().split(" ").map { it.toInt() }
        val s = br.readLine()
        val numZeroes = s.fold(0){acc, c ->  acc + if (c == '0') 1 else 0}
        val numOnes = s.length - numZeroes

        if (x > 0 && numZeroes < numOnes){
            println(0)
        }else{

        }
    }

}