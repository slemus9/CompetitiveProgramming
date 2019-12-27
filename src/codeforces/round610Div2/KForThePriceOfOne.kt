package codeforces.round610Div2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val (n, p, k) = br.readLine().split(" ").map { it.toInt() }
        val a = br.readLine().split(" ").map { it.toInt() }.sorted()
        println(maxGoods(a, p, k))
    }
}

fun maxGoods(a: List<Int>, p: Int, k: Int): Int{
    val n = a.size

    tailrec fun loopK(i: Int, sum: Int, count: Int): Int =
        if (i < n && sum + a[i] <= p) loopK(i + k, sum + a[i], count + k)
        else count

    tailrec fun go(i: Int, noProm: Int, maxSoFar: Int): Int =
        if (noProm <= p && i <= k && i < n){
            val count = loopK(i + k - 1, noProm, i)
            go(i + 1, noProm + a[i], max(maxSoFar, count))
        }
        else maxSoFar

    return go(0, 0, 0)
}