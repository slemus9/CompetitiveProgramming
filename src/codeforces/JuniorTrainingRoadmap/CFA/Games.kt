package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val colors = List(n){br.readLine().split(" ").map { it.toInt() }}
    val h = colors.map { it.first() }
    val a = colors.map { it.last() }.groupBy { it }
    println(
        h.fold(0){acc, h_i ->
            acc + a.getOrDefault(h_i, emptyList()).size
        }
    )
}