package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

tailrec fun gcd(a: Long, b: Long): Long =
    if (b == 0L) a
    else gcd(b, a % b)



fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { itL }
    val g = nums.fold(0L) { x, y -> gcd(x, y) }
    var i = 1L
    var count = 0

    while (i <= sqrt(g.toDouble())) {
        if (g % i == 0L) {
            if (g/i == i)
                count ++
            else
                count += 2
        }
        i++
    }
    println(count)
}