package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val r = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    var prev = 0
    var curr = 1
    var next = 2
    var cnt = k
    while (next < 2*n + 1 && cnt > 0) {
        if (r[prev] < r[curr] - 1 && r[curr] - 1 > r[next]) {
            r[curr] = r[curr] - 1
            cnt--
        }
        prev++
        curr++
        next++
    }
    println(r.joinToString(" "))
}