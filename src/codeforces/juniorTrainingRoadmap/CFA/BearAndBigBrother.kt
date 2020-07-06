package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    var L = a
    var B = b
    var n = 0
    while (L <= B) {
        L *= 3
        B *= 2
        n++
    }
    println(n)
}