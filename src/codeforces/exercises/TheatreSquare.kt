package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, a) = br.readLine().split(" ").map { it.toLong() }
    val ceil = {x: Long, y: Long -> if (x % y == 0L) x / y else x / y + 1}
    println(ceil(n, a) * ceil(m, a))
}