package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val distinct = s.groupBy { it }.keys.size
    println(
        if (distinct % 2 == 1){
            "IGNORE HIM!"
        } else {
            "CHAT WITH HER!"
        }
    )
}