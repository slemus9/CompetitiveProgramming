package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (min(n, m) % 2 == 0) "Malvika"
        else "Akshat"
    )
}