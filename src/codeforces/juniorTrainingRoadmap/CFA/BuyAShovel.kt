package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k, r) = br.readLine().split(" ").map { it.toInt() }
    var cnt = 1
    while (cnt < 10){
        if (cnt*k % 10 == r || cnt*k % 10 == 0){
            break
        }
        cnt++
    }
    println(cnt)
}