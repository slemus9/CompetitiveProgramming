package codeforces.global.GoodBy2019

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val (n, k1, k2) = br.readLine().split(" ").map { it.toInt() }
        val maxA = br.readLine().split(" ").map { it.toInt() }.max()?:-1
        val maxB = br.readLine().split(" ").map { it.toInt() }.max()?:-1
        println(if (maxA > maxB) "YES" else "NO")
    }
}