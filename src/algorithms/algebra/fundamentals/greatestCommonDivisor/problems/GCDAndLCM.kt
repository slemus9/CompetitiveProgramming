package algorithms.algebra.fundamentals.greatestCommonDivisor.problems

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.codechef.com/problems/FLOW016
 */
private tailrec fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a % b)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t){
        val ab = br.readLine().split(" ").map { it.toInt() }
        val a = ab[0]
        val b = ab[1]
        val g = gcd(a, b)
        val l = (a / g) * b
        println("$g $l")
    }
}