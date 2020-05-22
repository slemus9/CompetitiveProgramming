package codeforces.div2.educationalRound81

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val n = br.readLine().toInt()
        val numOnes = n/2
        if (n % 2 == 0){
            println("1".repeat(numOnes))
        }else{
            println("7" + "1".repeat((n - 3)/2))
        }
    }
}