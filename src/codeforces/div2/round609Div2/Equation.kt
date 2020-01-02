package codeforces.div2.round609Div2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

val N = BigInteger("100000000")

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toBigInteger()
    var a = n + 4.toBigInteger()
    var b = BigInteger("4")

    while (a < N && (a - b != n || (a.isProbablePrime(1) || b.isProbablePrime(1)))){
        a++
        b++
    }

    println("$a $b")
}