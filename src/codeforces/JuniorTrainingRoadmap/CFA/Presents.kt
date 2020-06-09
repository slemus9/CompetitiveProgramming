package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val p = br.readLine().split(" ").map { it.toInt() }.zip(1..n)
    val ans = (0..n).toMutableList()
    for ((p_i, i) in p) {
        ans[p_i] = i
    }
    println(ans.drop(1).joinToString(" "))
}