package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val x = br.readLine().split(" ").map { it.toLong() }

    for (i in x.indices){
        println(
            if (x[i] < 15 || x[i] % 14 == 0L || x[i] % 14 > 6) "NO"
            else "YES"
        )
    }
}