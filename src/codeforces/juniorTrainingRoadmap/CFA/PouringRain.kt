package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.asin

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (d, h, v, e) = br.readLine().split(" ").map { it.toDouble() }
    val pi = asin(1.0)*2
    val A = pi*d*d/4
    if (A*e >= v) {
        println("NO")
    } else {
        val ans = -A*h/(A*e - v)
        println("YES")
        println("%.12f".format(ans))
    }
}