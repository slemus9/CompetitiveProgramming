package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val h = listOf(0) + br.readLine().split(" ").map { it.toInt() }
    var energy = 0
    var dollars = 0
    for (i in 0 until h.size - 1) {
        if (energy + h[i] - h[i + 1] < 0) {
            dollars += h[i + 1] - h[i] - energy
            energy = 0
        } else {
            energy += h[i] - h[i + 1]
        }
    }
    println(dollars)
}