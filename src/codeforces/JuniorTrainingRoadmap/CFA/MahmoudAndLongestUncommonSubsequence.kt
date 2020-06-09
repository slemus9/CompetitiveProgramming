package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine()
    val b = br.readLine()
    println(
        if (a == b) - 1 else max(a.length, b.length)
    )
}