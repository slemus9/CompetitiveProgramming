package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val mod = {a: Int, b: Int -> (a % b + b) % b}
    for (i in 1 .. t) {
        val a = br.readLine().toInt()
        println(
            if (mod(-360, a - 180) == 0) "YES"
            else "NO"
        )
    }
}