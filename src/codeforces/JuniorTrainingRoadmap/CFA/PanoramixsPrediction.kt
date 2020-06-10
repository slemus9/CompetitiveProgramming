package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun prime (n: Int): Boolean {
    if (n == 1 || n == 2 || n == 3) return true
    else {
        var isPrime = true
        var i = 2
        while (i <= sqrt(n.toFloat()).toInt() && isPrime) {
            if (n % i == 0) {
                isPrime = false
            } else {
                i++
            }
        }
        return isPrime
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    if (!prime(m)){
        println("NO")
    } else {
        for (i in n + 1 .. m) {
            if (prime(i)){
                println(if (i == m) "YES" else "NO")
                break
            }
        }
    }
}