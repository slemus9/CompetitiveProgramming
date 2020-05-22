package codeforces.div2.round580

import java.io.BufferedReader
import java.io.InputStreamReader


fun arrMax(arr: List<Int>): Int{
    var max = 0
    for (a in arr){
        if (a > max) max = a
    }
    return max
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    val B = br.readLine().split(" ").map { it.toInt() }
    println("${arrMax(A)} ${arrMax(B)}")
}