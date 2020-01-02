package codeforces.div3.round611Div3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        println((n - n % k) + min(k/2, n % k))
    }
}
