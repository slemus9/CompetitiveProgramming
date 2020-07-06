package codeforces.global.round9

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun readInts () = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = readInts()
        val M = MutableList(n){readInts()}
        var possible = true
        var i = 0
        var j = 0

        while (i < n && possible) {
            while (j < m && possible) {
                if ((i == 0 && j == 0) || (i == 0 && j == m - 1) ||
                        (i == n - 1 && j == 0) || (i == n - 1 && j == m - 1)) {
                    if (M[i][j] > 2) {
                        possible = false
                    } else {
                        M[i][j] = 2
                    }
                } else if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (M[i][j] > 3) {
                        possible = false
                    } else {
                        M[i][j] = 3
                    }
                } else {
                    if (M[i][j] > 4) {
                        possible = false
                    } else {
                        M[i][j] = 4
                    }
                }
                j++
            }
            j = 0
            i++
        }

        if (possible) {
            println("YES")
            for (i in 0 until n) {
                println(M[i].joinToString(" "))
            }
        } else {
            println("NO")
        }
    }
}