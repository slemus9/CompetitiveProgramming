package codeforces.div2.educationalRound90

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t) {
        val (a, b, c) = br.readLine().split(" ").map { it.toLong() }
        val x = if (a < c) 1 else -1
        val y = if (a*b > c) b else -1
        println("$x $y")
    }
}