package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, b, d) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }
    var cnt = 0
    var inWasteSection = 0
    for (a_i in a) {
        if (a_i <= b){
            inWasteSection += a_i
            if (inWasteSection > d){
                inWasteSection = 0
                cnt++
            }
        }
    }
    println(cnt)
}