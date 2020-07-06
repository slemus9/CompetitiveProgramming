package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().split("+").map { it.toInt() }
    val count = Array(4){0}
    for (s_i in s){
        count[s_i]++
    }
    val ans = ArrayList<Int>()
    var i = 1
    while (i < 4){
        if (count[i] > 0){
            ans.add(i)
            count[i]--
        } else {
            i++
        }
    }
    println(ans.joinToString("+"))
}