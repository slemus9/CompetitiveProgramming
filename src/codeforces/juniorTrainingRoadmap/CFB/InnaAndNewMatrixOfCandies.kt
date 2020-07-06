package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val M = List(n){br.readLine()}
    var i = 0
    var j = 0
    var dwarfBeforeCandy = true
    val distances = ArrayList<Int>()

    while (i < n && dwarfBeforeCandy) {
        var dwj = -1
        while (j < m && dwarfBeforeCandy) {
            when (M[i][j]) {
                'S' -> if (dwj == -1) {
                        dwarfBeforeCandy = false
                    } else {
                        distances.add(j - dwj)
                    }
                'G' -> {
                    dwj = j
                }
            }
            j++
        }
        j = 0
        i++
    }

    if (dwarfBeforeCandy) {
        var moves = 0
        distances.sort()
        for (i in 0 until n) {
            val d = distances[i]
            if (d != 0) {
                for (j in i until n) {
                    distances[j] -= d
                }
                moves++
            }
        }
        println(moves)
    } else {
        println(-1)
    }
}