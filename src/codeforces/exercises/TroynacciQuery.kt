package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

val M = (10e9).toInt() + 7

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, q) = br.readLine().split(" ").map { it.toInt() }
    val (f1, f2) = br.readLine().split(" ").map { it.toLong()}
    val (a, b) = br.readLine().split(" ").map { it.toLong()}
    val x  = br.readLine().split(" ").map { it.toLong()}
}

fun troynacci (n: Int, f1: Long, f2: Long, a: Long, b: Long) : Array<Long> {
    val f = Array(n){_ -> 0L}
    f[0] = f1
    f[1] = f2
    for(i in 2 until n){
        f[i] = (a*f[i - 2] + b*f[i - 1]) % M
    }
    return f
}

fun computeF (i: Int, a: Long, b: Long, f: Array<Long>): Long =
    (a*f[i - 2] + b*f[i - 1]) % M

fun p (n: Int, a: Long, b: Long, f: Array<Long>, qs: List<Pair<Int, Int>>): Array<Long>{
    val p = Array(n){_ -> 0L}
    for ((l, r) in qs){

    }

    return p
}