package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    for (i in 1 .. n) {
        val certain = br.readLine().split(" ").map { it.toInt() }.sum()
        count += if (certain >= 2 ) 1 else 0
    }
    println(count)
}