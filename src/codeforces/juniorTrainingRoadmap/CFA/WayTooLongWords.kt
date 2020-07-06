package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val word = br.readLine()
        val trimed = word.drop(1).dropLast(1)
        println(
            if (word.length > 10){
                "${word.first()}${trimed.length}${word.last()}"
            } else {
                word
            }
        )
    }
}