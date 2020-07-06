package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun readInts () = br.readLine().split(" ").map { it.toInt() }
    var (n, k) = readInts()
    val a = readInts().toMutableList()

    var i = 0
    while (i < n && k > 0) {
        if (a[i] < 0) {
            a[i] *= -1
            k--
        }
        i++
    }
    val additional = if (k > 0 && k % 2 == 1) a.min()!! else 0
    println(a.sum() - 2*additional)
}