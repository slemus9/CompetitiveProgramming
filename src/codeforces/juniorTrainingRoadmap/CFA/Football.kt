package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val goals = List(n){br.readLine()}.groupBy { it }
    println(goals.maxBy { (_, gs) -> gs.size }!!.key)
}