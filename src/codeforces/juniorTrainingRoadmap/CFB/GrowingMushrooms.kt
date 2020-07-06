package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun readNums () = br.readLine().split(" ").map { it.toDouble() }
    val (n, t1, t2, k) = readNums()
    val speeds = List(n.toInt()){
        val (a, b) = readNums()
        a to b
    }

    val finalHeights = speeds.map { (a, b) ->
        max(a*t1*(1 - k/100) + t2*b, b*t1*(1 - k/100) + t2*a)
    }.zip(1..n.toInt()).sortedByDescending { it.first }

    for ((h, i) in finalHeights) {
        println("${i} ${"%.2f".format(h)}")
    }
}