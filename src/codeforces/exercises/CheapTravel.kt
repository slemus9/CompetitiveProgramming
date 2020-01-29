package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, a, b) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (b >= m*a) n*a
        else{
            val mRideTickets = n/m
            min(b, (n%m)*a) + mRideTickets*b
        }
    )

}