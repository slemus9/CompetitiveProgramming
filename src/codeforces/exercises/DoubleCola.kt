package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (w, sum) = findWindow(n)
    val segmentSize = pow(2, w.toLong())
    val i = if (n <= 5) 1 else sum - 5*segmentSize
    val j = n - i
    println(
        when (j / segmentSize){
            0L -> "Sheldon"
            1L -> "Leonard"
            2L -> "Penny"
            3L -> "Rajesh"
            else -> "Howard"
        }
    )

}

fun pow(a: Long, n: Long): Long {
    tailrec fun go(a: Long, n: Long, acc: Long): Long =
        if (a == 0L)  0
        else if (n == 0L)  1
        else if (n == 1L) a * acc
        else if (n % 2 == 0L) go(a * a, n/2, acc)
        else go(a * a, (n - 1)/2, a * acc)

    return go(a, n, 1)
}

fun findWindow (n: Int): Pair<Int, Int>{
    tailrec fun go (i: Int, sum: Int, exp: Int): Pair<Int, Int> =
        if (n <= sum) i to sum
        else go(i + 1, sum + 5*exp, exp*2)

    return go(0, 5, 2)
}