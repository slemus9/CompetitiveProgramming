package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val crimes = br.readLine().split(" ").map { it.toInt() }
    var police = 0
    var untreated = 0
    for (i in 0 until n){
        if (crimes[i] < 0) {
            if (police == 0) {
                untreated++
            } else {
                police--
            }
        } else {
            police += crimes[i]
        }
    }
    println(untreated)
}