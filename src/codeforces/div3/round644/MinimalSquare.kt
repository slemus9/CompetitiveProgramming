package codeforces.div3.round644

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val side = max(2*min(a, b), max(a, b))
        println(side*side)
    }
}