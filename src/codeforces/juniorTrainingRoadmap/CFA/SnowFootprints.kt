package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val road = br.readLine().toList().zip(1..n)
    val groups = road.groupBy { it.first }
    if (!('R' in groups)) {
        val lGroup = groups['L']!!
        println("${lGroup.last().second} ${lGroup.first().second - 1}")
    } else if (!('L' in groups)) {
        val rGroup = groups['R']!!
        println("${rGroup.first().second} ${rGroup.last().second + 1}")
    } else {
        val lGroup = groups['L']!!
        println("${lGroup.last().second} ${lGroup.first().second}")
    }
}