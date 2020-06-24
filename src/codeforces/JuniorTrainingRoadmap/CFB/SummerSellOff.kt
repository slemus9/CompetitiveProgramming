package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, f) = br.readLine().split(" ").map { it.toInt() }
    fun min (a: Long, b: Long) = if (a < b) a else b
    val products = List(n){
        val (k, l) = br.readLine().split(" ").map { it.toLong() }
        k to l
    }.sortedBy{min(it.first, it.second) - min(2*it.first, it.second)}

    println(
        products.take(f).fold(0L){acc, (k, l) -> acc + min(2*k, l)} +
                products.drop(f).fold(0L){acc, (k, l) -> acc + min(k, l)}
    )
}