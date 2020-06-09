package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val xLevels = br.readLine().split(" ").map { it.toInt() }.drop(1)
    val yLevels = br.readLine().split(" ").map { it.toInt() }.drop(1)
    val passed = (xLevels.toSet() + yLevels.toSet()).containsAll((1..n).toList())
    println(
        if (passed) "I become the guy." else "Oh, my keyboard!"
    )
}