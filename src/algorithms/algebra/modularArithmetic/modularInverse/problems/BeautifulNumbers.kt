package algorithms.algebra.modularArithmetic.modularInverse.problems

import java.io.BufferedReader
import java.io.InputStreamReader

val m = (1e9 + 7).toLong()
val maxN = (1e6 + 300).toInt()
val fact by lazy { precFact() }

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val abn = br.readLine().split(" ").map { it.toInt() }
    val a = abn[0]
    val b = abn[1]
    val n = abn[2]

    println(numWays(a, b, n))

}

fun numWays(a: Int, b: Int, n: Int): Long{
    tailrec fun go(i: Int, acc: Long): Long =
        if (i == n + 1) acc % m
        else if (isGood(a*i + b*(n-i), a, b)){
            go(i + 1, combination(n, i) + acc)
        }
        else
            go(i + 1, acc)
    return go(0, 0)
}


fun combination(n: Int, i: Int): Long {
    val inv = binExp(fact[i]*fact[n - i], m - 2, m)
    return (fact[n] * inv) % m
}

fun isGood(num: Int, a: Int, b: Int): Boolean{
    tailrec fun go(digit: Int, rest: Int, a: Int, b: Int): Boolean =
        if (rest == 0) digit == a || digit == b
        else{
            if (digit != a && digit != b) false
            else go(rest % 10, rest / 10, a, b)
        }
    return go(num % 10, num / 10, a, b)
}

fun binExp(a: Long, x: Long, m: Long): Long{
    tailrec fun go(a: Long, x: Long, acc: Long): Long =
        if (x == 0L) 1
        else {
            if (x == 1L) (a * acc) % m
            else if (x % 2 == 0L) go((a * a) % m, x/2, acc)
            else go((a * a) % m, (x - 1)/2, (a * acc) % m)
        }
    return go(a % m, x ,1)
}


fun precFact(): Array<Long>{
    val fact = Array(maxN){_ -> 0L}
    fact[0] = 1
    for (i in 1 until maxN){
        fact[i] = (i % m * fact[i - 1] % m ) % m
    }
    return fact
}