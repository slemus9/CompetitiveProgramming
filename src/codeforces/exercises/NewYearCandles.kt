package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toInt()}
    var i = a
    var candles = a
    while (i >= b){
        candles += i/b
        i = i/b + i % b
    }

    println(candles)
}