package codeforces.div3.round644

import java.io.BufferedReader
import java.io.InputStreamReader

object Polygon {
    fun isValid (M: List<List<Int>>, i: Int, j: Int, n: Int): Boolean =
        (i == n - 1) || (j == n - 1) || (M[i][j + 1] == 1) || (M[i + 1][j] == 1)

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()
        for (i in 1 .. t) {
            val n = br.readLine().toInt()
            val M = List(n){br.readLine().split("").filter { it != "" }.map { it.toInt() }}
            var allValid = true
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (M[i][j] == 1) {
                        allValid = allValid && isValid(M, i, j, n)
                    }
                }
            }
            println(if (allValid) "YES" else "NO")
        }
    }
}

fun main() {
    Polygon.main()
}
