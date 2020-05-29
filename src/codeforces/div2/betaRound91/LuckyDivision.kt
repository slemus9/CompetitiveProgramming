package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = sqrt(n.toDouble()).toInt()
    val almostLucky = (1 .. m).dropWhile { x ->
        !(n % x == 0 && (isLucky(x) || isLucky(n / x)))
    }
    println(if (almostLucky.isNotEmpty()) "YES" else "NO")
}

fun isLucky (n : Int): Boolean{
    var curr = n
    while (curr != 0){
        val digit = curr % 10
        curr /= 10
        if (digit != 4 && digit != 7){
            return false
        }
    }
    return true
}