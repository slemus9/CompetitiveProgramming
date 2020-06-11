package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val square = List(4){br.readLine().map { if (it == '#') 1 else 0}}
    var possible = false
    for (i in 0 .. 2){
        for (j in 0 .. 2){
            val sum = square[i][j] + square[i][j + 1] +
                    square[i + 1][j] + square[i + 1][j + 1]
            if (sum != 2) {
                possible = true
                break
            }
        }
        if (possible) break
    }
    println(if (possible) "YES" else "NO")
}