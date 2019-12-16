package algorithms.algebra.fundamentals.binaryExponentiation.problems

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.spoj.com/problems/LOCKER/
 */
private val m: Long = 1000000007
val zero = 0L
val one = 1L

private fun binExpMod(a: Long, n: Long): Long{
    tailrec fun go(a: Long, n: Long, a1: Long): Long{
        if (a == zero) return 0
        if (n == zero) return 1
        if (n == one) return (a * a1) % m
        if (n % 2 == zero) return go((a % m * a % m) % m, n/2, a1)
        else return go((a % m * a % m) % m, (n - 1)/2, (a % m * a1 % m) % m)
    }
    return go(a, n, 1)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 1 .. t){
        val n = br.readLine()L
        if (n < 4){
            println(n)
        }else{
            val rem = n % 3
            if (rem == zero){
                println(binExpMod(3,n/3))
            }else if (rem == one){
                println((4*binExpMod(3,(n - 4)/3)) % m)
            }else{
                println((2* binExpMod(3,(n - 2)/3)) % m)
            }
        }
    }
}