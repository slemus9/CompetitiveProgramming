package codeforces.div2.educationalRound90

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t) {
        val s = br.readLine()
        val numZeros = s.count { it == '0' }
        val numOnes = s.length - numZeros
        println(
            if (min(numOnes, numZeros) % 2 == 0) {
                "NET"
            } else {
                "DA"
            }
        )
    }
}