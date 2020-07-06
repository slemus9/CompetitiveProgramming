package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = List(n){br.readLine().toInt()}
    val ans = a.fold(ArrayList<Int>() to 1){(acc, delta), a_i ->
        if (a_i % 2 == 0) acc.apply { add(a_i/2) } to delta
        else acc.apply { add((a_i + delta)/2) } to -delta
    }.first
    println(ans.joinToString("\n"))
}