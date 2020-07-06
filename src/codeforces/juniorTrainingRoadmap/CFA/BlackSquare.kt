package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().split(" ").map { it.toInt() }
    val s = br.readLine().split("").filter { it != "" }.map { it.toInt() - 1}
    println(
        s.fold(0){acc, strip ->
            acc + a[strip]
        }
    )
}