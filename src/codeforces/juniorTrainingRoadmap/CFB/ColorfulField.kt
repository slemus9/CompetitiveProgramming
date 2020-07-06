package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k, t) = br.readLine().split(" ").map { it.toInt() }
    val waste = List(k){
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        i to j
    }.toSet()

    val plants = listOf("Carrots", "Kiwis", "Grapes")
    for (i in 1 .. t) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        if ((a to b) in waste) {
            println("Waste")
        } else {
            val pos = ((a - 1)*m + b - waste.filter { (wi, wj) ->
                a > wi || (wi == a && wj < b)
            }.size - 1) % 3
            println(plants[pos])
        }
    }
}