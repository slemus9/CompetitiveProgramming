package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
        .zip(0 until n).sortedBy { it.first }
    val m = br.readLine().toInt()
    val b = br.readLine().split(" ").map { it.toInt() }
    var fst = 0L
    var snd = 0L

    for (b_i in b) {
        var l = 0
        var r = n - 1
        while (l <= r) {
            val m = (l + r) / 2
            if (b_i < a[m].first) {
                r = m - 1
            } else if (b_i > a[m].first) {
                l = m + 1
            } else {
                fst += a[m].second + 1
                snd += n - a[m].second
                break
            }
        }
    }

    println("$fst $snd")
}