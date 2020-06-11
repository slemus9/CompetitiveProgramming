package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toLong() }
    val minBound = min(n, m)
    val maxBound = max(n, m)
    println((1..minBound).fold(0L){acc, i ->
        acc + (maxBound + i)/5 - i/5
    })
}