package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toDouble() }
    var i = a
    var candles = a
    while (i > 1){
        i /= b
        candles += i
    }
    println(candles.toInt())
}