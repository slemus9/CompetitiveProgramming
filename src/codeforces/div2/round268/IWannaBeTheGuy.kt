package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val line1 = br.readLine().split(" ").map { it.toInt() }
    val line2 = br.readLine().split(" ").map { it.toInt() }
    val p1 = line1.first()
    val p2 = line2.first()
    val ax = line1.drop(1)
    val ay = line2.drop(1)
    val count = Array(n + 1){0}

    for (ax_i in ax){
        count[ax_i]++
    }

    for (ay_i in ay){
        count[ay_i]++
    }

    var incomplete = false
    var i = 1
    while (i <= n && !incomplete){
        if (count[i] == 0) incomplete = true
        i++
    }

    println(if (!incomplete) "I become the guy." else "Oh, my keyboard!")
}