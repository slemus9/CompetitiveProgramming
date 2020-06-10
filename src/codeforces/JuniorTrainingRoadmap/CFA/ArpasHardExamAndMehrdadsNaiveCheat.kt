package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val digits = listOf(8, 4, 2, 6)
    println(if (n == 0) 1 else digits[(n - 1) % 4])
}