package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val colors = "ROYGBIV"
    println(
        if (n <= 7) {
            colors.take(n)
        } else {
            val rest =
                if (n % 7 <= 4) colors.substring(3 until  3 + n % 7)
                else colors.take(n % 7)
            colors.repeat(n / 7) + rest
        }
    )
}