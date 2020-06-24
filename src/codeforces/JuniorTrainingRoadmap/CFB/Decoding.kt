package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = br.readLine()
    var order = if (n % 2 == 0) 0 else 1
    val ans = StringBuilder()
    for (c in s) {
        if (order == 0) {
            ans.insert(0, c)
        } else {
            ans.append(c)
        }
        order = (order + 1) % 2
    }
    println(ans)
}