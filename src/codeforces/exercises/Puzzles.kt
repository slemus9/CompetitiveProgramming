package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val f = br.readLine().split(" ").map { it.toInt() }.sorted()
    var ans = 10000
    var i = 0
    var j = i + n - 1
    while (j < m){
        ans = min(ans, f[j] - f[i])
        i++
        j = i + n - 1
    }
    println(ans)
}