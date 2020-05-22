package codeforces.div3.round611

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val (h, m) = br.readLine().split(" ").map { it.toInt() }
        println((60 - m) + (23 - h)* 60)
    }
}