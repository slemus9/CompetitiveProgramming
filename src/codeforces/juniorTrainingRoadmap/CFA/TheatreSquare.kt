package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, a) = br.readLine().split(" ").map { it.toLong() }
    val ceil = {a: Long, b: Long -> (a + b - 1)/b}
    println(ceil(n, a) * ceil(m, a))
}