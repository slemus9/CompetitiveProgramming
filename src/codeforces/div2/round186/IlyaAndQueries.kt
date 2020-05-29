package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val n = br.readLine().toInt()
    val sumArr = computeSumArray(s)

    for (i in 0 until n){
        val q = br.readLine().split(" ").map { it.toInt() }
        val l = q[0] - 1
        val r = q[1] - 1
        println(sumArr[r] - sumArr[l])
    }
}

fun computeSumArray(s: String): Array<Int>{
    val n = s.length
    val sumArr = Array(n){x -> 0}

    for (i in 1 until n){
        if (s[i] == s[i - 1]) sumArr[i] = sumArr[i - 1] + 1
        else sumArr[i] = sumArr[i - 1]
    }

    return sumArr
}