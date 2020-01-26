package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    println(
        if (n % 2 == 0L) n/2
        else -(n + 1)/2
    )
}