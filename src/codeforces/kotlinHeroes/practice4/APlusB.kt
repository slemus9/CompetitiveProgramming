package codeforces.kotlinHeroes.practice4

import java.io.BufferedReader
import java.io.InputStreamReader

object APlusB {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()
        for (i in 1 .. t) {
            println(br.readLine().split(" ").map { it.toInt() }.sum())
        }
    }
}

fun main() {
    APlusB.main()
}