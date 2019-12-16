package algorithms.algebra.fundamentals.binaryExponentiation.problems

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.spoj.com/problems/ZSUM/
 */
private val m: Int = 10000007

private fun binExpMod(a: Long, n: Long): Long{
    if (n == 0L) return 1

    var x = a
    var y = 1L
    var count = n
    while (count > 0){
        if (count % 2 != 0L) y = (x * y) % m
        count = count shr 1
        x = (x * x) % m
    }
    return y
}

/**
 * Z_n + Z_{n -1} + 2*Z_{n - 2} = 2(n-1)^k + 2(n - 1)^{n-1} + n^k + n^n
 */
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var nk = br.readLine().split(" ").map { it.toLong() }

    while (nk[0] != 0L || nk[1] != 0L){
        val n = nk[0]
        val k = nk[1]
        val result = (2*(binExpMod(n-1,k) + binExpMod(n-1,n-1)) + binExpMod(n,k) + binExpMod(n,n)) % m
        println(result)
        nk = br.readLine().split(" ").map { it.toLong() }
    }
}