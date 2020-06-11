package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val groups = a.groupBy { it }
    val (maxNum, maxGroup) = groups.maxBy { (_, xs) -> xs.size }!!
    println(
        if (maxGroup.size <= (n + 1)/2) "YES"
        else "NO"
    )
}