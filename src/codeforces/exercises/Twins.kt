package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    val sumArray = getSumArr(a, n)
    var takenTotal = 0
    var i = 0

    while (i < n - 1){
        takenTotal += a[i]
        if (takenTotal > sumArray[i + 1]) break
        i++
    }
    println(i + 1)
}

fun getSumArr (a: List<Int>, n: Int): Array<Int>{
    val sumArr = Array(n){0}
    sumArr[n - 1] = a[n - 1]
    for (i in n - 2 downTo 0){
        sumArr[i] += a[i] + sumArr[i + 1]
    }
    return sumArr
}