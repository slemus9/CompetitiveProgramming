package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine().toInt()
    val bin = x.toString(2)
    println(bin.fold(0){acc, c ->  acc + if (c == '1') 1 else 0})
}
