package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, t) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (t == 10 && n == 1) "-1"
        else if (t < 10) "$t" + "0".repeat(n - 1)
        else "1" + "0".repeat(n - 1)
    )
}