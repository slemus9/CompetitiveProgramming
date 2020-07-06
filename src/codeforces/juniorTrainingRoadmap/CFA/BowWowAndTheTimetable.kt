package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val n = s.length
    println(
        if (s == "0") {
            0
        } else if (s.filter { it == '1' }.length == 1) {
            n/2
        } else {
            (n + 1)/2
        }
    )
}