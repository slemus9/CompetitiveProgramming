package algorithms.algebra.fundamentals.greatestCommonDivisor.problems

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * http://codeforces.com/gym/100963/attachments
 */
val zero = 0.toLong()

private fun xgcd(a: Long, b: Long): Triple<Long, Long, Long>{
    tailrec fun go(a: Long, b: Long, x: Long, y: Long, prevx: Long, prevy: Long): Triple<Long, Long, Long> =
            if (b == zero) Triple(a, prevx, prevy)
            else {
                val q = a/b
                go(b, a % b, prevx - q*x, prevy - q*y, x, y)
            }
    return go(a, b, 0, 1, 1, 0)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var nmak = br.readLine().split(" ").map { it.toLong() }

    while (nmak[0] != zero || nmak[1] != zero || nmak[2] != zero || nmak[3] != zero  ){
        val n = nmak[0]
        val m = nmak[1]
        val a = nmak[2]
        val k = nmak[3]

        val c = a + k - n
        val gcd = xgcd(m, k)
        val g = gcd.first
        val x = gcd.second

        if (c % g != zero){
            println("Impossible")
        }else{
            println(n + x*(c/g)*m)
        }

        nmak = br.readLine().split(" ").map { it.toLong() }
    }

}