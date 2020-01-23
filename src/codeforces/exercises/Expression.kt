package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nums = Array(3){0}
    for (i in 0 until 3){
        nums[i] = br.readLine().toInt()
    }
    val a = nums[0]
    val b = nums[1]
    val c = nums[2]
    val options = listOf(
        a + b + c,
        a * b * c,
        (a + b)*c,
        a*(b + c),
        a*b + c,
        a + b*c
    )
    println(options.max())
}