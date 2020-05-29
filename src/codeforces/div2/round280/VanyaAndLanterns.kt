package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ")
                        .map { it.toInt() }.sorted()

    val adjPairs = (listOf(0) + a).zipWithNext()
    val diff = adjPairs.maxBy { (x, y) -> y - x }
    val d = (diff!!.second - diff!!.first).toDouble() / 2
    println("%.10f".format(max(d, max((l - a[n - 1]).toDouble(), a[0].toDouble()))))
}