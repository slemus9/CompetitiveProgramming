package codeforces.kotlinHeroes.practice4

import java.io.BufferedReader
import java.io.InputStreamReader

object Square {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()
        for (i in 1 .. t) {
            val (a1, b1) = br.readLine().split(" ").map { it.toInt() }
            val (a2, b2) = br.readLine().split(" ").map { it.toInt() }
            val maxSide = listOf(a1, b1, a2, b2). max()
            val equalSide =
                if ((a1 == a2 || a1 == b2) && a1 == maxSide) a1
                else
                    if ((b1 == a2 || b1 == b2) && b1 == maxSide) b1
                    else -1
            if (equalSide == -1){
                println("No")
            } else {
                val unequalSides = listOf(a1, b1, a2, b2).filter { it != equalSide }
                if (unequalSides.sum() == equalSide) {
                    println("Yes")
                } else {
                    println("No")
                }
            }
        }
    }
}

fun main() {
    Square.main()
}