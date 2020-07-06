package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    val b = br.readLine().split(" ").map { it.toInt() }
    val positions = MutableList(n + 1){0}
    for (i in 0 until n) {
        positions[a[i]] = i
    }

    val (fst, snd) = b.fold(0L to 0L){(fst, snd), b_i ->
        fst + positions[b_i] + 1 to snd + n - positions[b_i]
    }
    println("$fst $snd")
}