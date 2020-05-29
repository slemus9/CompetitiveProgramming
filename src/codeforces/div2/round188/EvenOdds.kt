package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toLong() }
    val numOdd = if (n % 2 == 0L) n/2 else n/2 + 1
    println(if (k <= numOdd) 2*(k - 1) + 1 else 2*(k - numOdd))
}