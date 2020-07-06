package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }
    var i = 0
    var j = n - 1
    var turn = 0
    val ans = Array(2){0}
    while (i <= j) {
        if (cards[i] > cards[j]) {
            ans[turn % 2] += cards[i]
            i++
        } else {
            ans[turn % 2] += cards[j]
            j--
        }
        turn++
    }
    println(ans.joinToString(" "))
}