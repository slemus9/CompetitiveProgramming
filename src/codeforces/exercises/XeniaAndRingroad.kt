package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toLong() }
    var steps = a[0] - 1

    for (i in 1 until m){
        val curr = a[i]
        val prev = a[i - 1]
        steps +=
            if (curr >= prev) curr - prev
            else (n - prev) + curr
    }
    println(steps)
}
