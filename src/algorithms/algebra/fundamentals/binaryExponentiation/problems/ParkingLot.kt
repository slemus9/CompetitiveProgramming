package algorithms.algebra.fundamentals.binaryExponentiation

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * http://codeforces.com/problemset/problem/630/I
 */
fun binExp(a: Long, n: Long): Long{
    tailrec fun go(a: Long, n: Long, a1: Long): Long{
        if (n == 0L) return 1
        if (n == 1L) return a * a1

        if (n % 2 == 0L) return go(a * a, n/2, a1)
        else return go(a * a, (n - 1)/2, a * a1)
    }
    return go(a, n, 1)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val x1 = 4*3* binExp(4, (n - 3).toLong())*2
    val x2 = if (n > 3) 4*3*3* binExp(4, (n - 4).toLong())*(n - 3) else 0
    println(x1 + x2)
}