package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val unique = a.toSortedSet()
    if (unique.size <= 3) {
        val diffs = unique.zipWithNext().map { it.second - it.first }
        if (diffs.all { it == diffs.first() }) {
            println("YES")
        } else {
            println("NO")
        }
    } else {
        println("NO")
    }
}