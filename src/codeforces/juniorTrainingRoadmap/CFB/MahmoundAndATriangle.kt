package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }.sorted()
    var possible = false
    for (i in 1 until n - 1) {
        if (a[i - 1] + a[i] > a[i + 1]){
            println("YES")
            possible = true
            break
        }
    }
    if (!possible){
        println("NO")
    }
}