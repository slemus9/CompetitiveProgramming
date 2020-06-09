package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = br.readLine().drop(1).dropLast(1)
        .split(", ")
    println(
        if (set.first() == ""){
            0
        } else {
            set.toSet().size
        }
    )
}