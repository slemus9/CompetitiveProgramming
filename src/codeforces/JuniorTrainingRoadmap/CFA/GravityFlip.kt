package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val count = Array(101){0}
    for (a_i in a) {
        count[a_i]++
    }
    val ans = ArrayList<Int>()
    var i = 0
    while (i < count.size && ans.size < n) {
        if (count[i] > 0) {
            ans.add(i)
            count[i]--
        } else {
            i++
        }
    }
    println(ans.joinToString(" "))
}