package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val x = br.readLine().toInt()
    val tower = List(n){br.readLine().split(" ").map { it.toInt() }}
        .map { it[0] to it[1] }
    val possible = tower.all { (a, b) -> a != x && b != x && a + x != 7 && b + x != 7 }
    println(if (possible) "YES" else "NO")
}