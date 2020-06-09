package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val maxStrenght = a.max()!!
    val minStrenght = a.min()!!
    println(a.filter { it != minStrenght && it != maxStrenght }.size)
}