package codeforces.div3.round644

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t) {
        val n = br.readLine().toInt()
        val s = br.readLine().split(" ").map { it.toInt() }.sorted()
        println(s.zipWithNext().fold(Int.MAX_VALUE, { acc, (x, y) -> min(acc, abs(x - y))}))
    }
}