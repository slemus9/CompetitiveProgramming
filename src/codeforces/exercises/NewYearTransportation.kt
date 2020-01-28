package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, t) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map {it.toInt()}

    var i = 1
    while (i < t){
        i += a[i - 1]
    }

    println(if (i == t) "YES" else "NO")
}