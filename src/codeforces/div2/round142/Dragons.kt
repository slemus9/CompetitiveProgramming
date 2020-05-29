package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (s, n) = br.readLine().split(" ").map { it.toInt() }
    var xAndY = emptyList<Pair<Int, Int>>()
    for (i in 0 until n){
        val (x_i, y_i) = br.readLine().split(" ").map { it.toInt() }
        xAndY += x_i to y_i
    }

    xAndY = xAndY.sortedBy { it.first }
    var currS = s
    var defeated = false
    var i = 0

    while (i < n && !defeated){
        val (d, b) = xAndY[i]
        if (currS <= d){
            defeated = true
        }else{
            currS += b
            i++
        }
    }

    println(if (defeated) "NO" else "YES")
}