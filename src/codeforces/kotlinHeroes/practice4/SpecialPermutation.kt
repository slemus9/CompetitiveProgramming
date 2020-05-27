package codeforces.kotlinHeroes.practice4

import java.io.BufferedReader
import java.io.InputStreamReader

object SpecialPermutation {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()
        for (i in 1 .. t) {
            val n = br.readLine().toInt()
            val nums = 1 .. n
            val G = nums.map { x ->
                (2 .. 4).map { listOf(x - it, it + x) }
                    .flatten()
                    .filter { it in nums }
            }

            
        }
    }
}

fun main() {
    SpecialPermutation.main()
}