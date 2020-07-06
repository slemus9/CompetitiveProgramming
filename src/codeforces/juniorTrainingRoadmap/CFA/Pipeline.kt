package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toLong() }
    val maxBound = k*(k - 1)/ 2 + 1
    if (maxBound < n) {
        println(-1)
    } else if (n == 1L) {
        println(0)
    } else {
        var l = 1L
        var r = k
        while (l < r) {
            val m = (l + r)/2
            val x = (m*(2*k - m - 1))/2 + 1
            if (x >= n) {
                r = m
            } else {
                l = m + 1
            }
        }
        println(l)
    }
}