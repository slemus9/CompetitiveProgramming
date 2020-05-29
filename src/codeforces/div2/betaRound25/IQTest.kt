package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val evenness = nums.map { x -> if (x % 2 == 0) 1 else 0}
    val isElemEven = evenness.sum() == 1
    val ans = 1 +
        if (isElemEven) evenness.indexOf(1)
        else evenness.indexOf(0)
    println(ans)
}