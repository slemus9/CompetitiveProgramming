package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val square = List(n){br.readLine()}
    val diagonal = square[0][0]
    val rest = square[0][1]
    if (diagonal == rest){
        println("NO")
    } else {
        var formsX = true
        var i = 0
        var j = 0
        while (i < n && formsX){
            while (j < n && formsX){
                if (i == j || j == n - 1 - i) {
                    formsX = square[i][j] == diagonal
                } else {
                    formsX = square[i][j] == rest
                }
                j++
            }
            j = 0
            i++
        }
        println(if (formsX) "YES" else "NO")
    }
}