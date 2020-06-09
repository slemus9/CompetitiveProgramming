package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val t = br.readLine()
    var pos = 0
    for (c in t) {
        if (c == s[pos]){
            pos++
        }
    }
    println(pos + 1)
}