package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val magnets = List(n){br.readLine()}
    var prev = magnets.first()
    var count = 1
    for (i in 1 until n){
        val curr = magnets[i]
        if (curr[0] == prev[1]){
            count++
        }
        prev = curr
    }
    println(count)
}