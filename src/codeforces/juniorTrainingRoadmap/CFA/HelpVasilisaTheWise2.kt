package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r1, r2) = br.readLine().split(" ").map { it.toInt() }
    val (c1, c2) = br.readLine().split(" ").map { it.toInt() }
    val (d1, d2) = br.readLine().split(" ").map { it.toInt() }
    val x4 = -(d2 - c2 - r2)/2
    val x3 = r2 - x4
    val x2 = d2 - x3
    val x1 = r1 - x2
    val sol = listOf(x1, x2, x3, x4)
    println(
        if (sol.all { it in (1..9) } && sol.toSet().size == sol.size &&
            -(d2 - c2 - r2) % 2 == 0) {
            "$x1 $x2\n$x3 $x4"
        } else {
            "-1"
        }
    )
}