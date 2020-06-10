package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun gcd (a: Long, b: Long): Long =
    if (b == 0L) a
    else gcd(b, a % b)

fun isCoprime (a: Long, b: Long) = gcd(a, b) == 1L

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (l, r) = br.readLine().split(" ").map { it.toLong() }
    var found = false
    for (i in l .. r) {
        for (j in i+1 .. r){
            for (w in j+1 .. r) {
                if (isCoprime(i, j) && isCoprime(j, w)) {
                    if (!isCoprime(i, w)){
                        val counterExample = listOf(i, j, w).sorted()
                        println(counterExample.joinToString(" "))
                        found = true
                        break
                    }
                }
            }
            if (found) break
        }
        if (found) break
    }
    if (!found) println(-1)
}