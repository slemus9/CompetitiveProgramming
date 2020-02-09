package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine( ).toInt()
    val v = br.readLine().split(" ").map { it.toInt() }
    val arr = buildInvArrMin(v)
    var i = 0
    var start = 0
    var end = 0
    var imp = false
    var foundBreakpoint = false



    println(
        if (imp) "impossible"
        else "${start + 1} ${end + 1}"
    )
}

fun buildInvArrMin (v: List<Int>): Array<Pair<Int, Int>>{
    val n = v.size
    val arr = Array(n){0 to 0}
    arr[n - 1] = v[n - 1] to n - 1
    for (i in n - 2 downTo 0){
        if (v[i] < arr[i + 1].first){
            arr[i] = v[i] to i
        }else{
            arr[i] = arr[i + 1]
        }
    }
    return arr
}