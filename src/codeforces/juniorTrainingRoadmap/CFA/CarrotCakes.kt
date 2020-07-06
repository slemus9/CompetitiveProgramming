package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, t, k, d) = br.readLine().split(" ").map { it.toInt() }
    val noExtraOven = t*((n + k - 1)/k)
    println(
        if (k >= n) "NO"
        else if (d + t < noExtraOven) "YES"
        else "NO"
    )
}