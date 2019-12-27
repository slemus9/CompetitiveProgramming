package codeforces.educationalRound79Div2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val colors = br.readLine().split(" ").map { it.toInt() }.sorted()
        println(if (colors[2] - (colors[1] + colors[0]) > 1) "No" else "Yes")
    }
}