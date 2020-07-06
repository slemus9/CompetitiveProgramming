package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val m = br.readLine().toInt()
    for (i in 0 until  m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        val wire = x - 1
        val left = y - 1
        val right = a[wire] - y
        if (wire > 0) {
            a[wire - 1] += left
        }
        if (wire < n - 1) {
            a[wire + 1] += right
        }
        a[wire] = 0
    }
    for (a_i in a){
        println(a_i)
    }
}