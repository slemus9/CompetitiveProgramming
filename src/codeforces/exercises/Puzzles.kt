package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val f = br.readLine().split(" ").map { it.toInt() }.sorted().zipWithNext()
    println(f.fold(100000){acc, (x, y) ->
        if (y == x) 100000
        else min(acc, y - x) }
    )
}