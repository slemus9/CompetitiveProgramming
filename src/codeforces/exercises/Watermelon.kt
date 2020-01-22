package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val w = br.readLine().toInt()
    println(
        if (w <= 2) "NO"
        else
            if ((w - 2) % 2 == 0) "YES"
            else "NO"
    )
}