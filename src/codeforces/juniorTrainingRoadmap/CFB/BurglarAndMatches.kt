package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val matches = List(m){br.readLine().split(" ").map { it.toInt() }}
        .sortedByDescending { it[1] }
    var cnt = 0
    var takenBoxes = 0
    var i = 0
    var full = false
    while (i < m && !full) {
        val (a, b) = matches[i]
        if (takenBoxes + a <= n) {
            cnt += a*b
            takenBoxes += a
            i++
        } else {
            cnt += (n - takenBoxes)*b
            full = true
        }
    }
    println(cnt)
}