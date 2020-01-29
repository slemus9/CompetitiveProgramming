package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val x = br.readLine().split(" ").map { it.toLong() }
    val N = (10e5).toInt()
    val prime = Array(N + 1){true}
    var p = 2
    while (p*p <= N){
        if (prime[p]){
            var i = p*p
            while (i <= N){
                prime[i] = false
                i += p
            }
        }
        p++
    }

    for (x_i in x){
        val sqr = sqrt(x_i.toDouble()).toLong()
        println(
            if (x_i == 1L || sqr*sqr != x_i) "NO"
            else{
                if (prime[sqr.toInt()]) "YES"
                else "NO"
            }
        )
    }
}