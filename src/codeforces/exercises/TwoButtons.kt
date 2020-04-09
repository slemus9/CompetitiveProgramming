package codeforces.exercises

import algorithms.algebra.fundamentals.greatestCommonDivisor.zero
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    TwoButtons.main()
}

object TwoButtons {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toLong() }
        val (gcd, xg, yg) = gcdExtended(2*n, n - 1)
        val x = xg*m/gcd
        val y = yg+m/gcd
        println(x + y)
    }

    fun gcdExtended(a: Long, b: Long): Triple<Long, Long, Long>{
        tailrec fun go(a: Long, b: Long, x: Long, y: Long, prevx: Long, prevy: Long): Triple<Long, Long, Long> =
            if (b == zero) Triple(a, prevx, prevy)
            else {
                val q = a/b
                go(b, a % b, prevx -  q*x, prevy - q*y, x, y)
            }
        return go(a, b, 0, 1, 1, 0)
    }
}
