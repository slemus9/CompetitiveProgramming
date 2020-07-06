package codeforces.global.round9

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val a = br.readLine().split(" ").map { it.toInt() }
                .mapIndexed {idx, x ->
                    if (idx % 2 == 1 && x > 0) -x
                    else if (idx % 2 == 0 && x < 0) -x
                    else x
                }
        println(a.joinToString(" "))
    }
}