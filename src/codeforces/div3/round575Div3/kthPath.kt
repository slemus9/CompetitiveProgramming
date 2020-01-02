package codeforces.div3.round575Div3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nmk = br.readLine().split(" ").map { it.toInt() }
    val n = nmk[0]
    val m = nmk[1]
    val k = nmk[2]

    val graph = Array(n + 1){ Array(n + 1){x -> 1e6}}

    for (i in 1 .. m){
        val xyw = br.readLine().split(" ").map { it.toInt() }
        val x = xyw[0]
        val y = xyw[1]
        val w = xyw[2].toDouble()
        graph[x][y] = w
        graph[y][x] = w
    }

    for (k in 0 until n){
        for (i in 0 until n){
            for (j in 0 until n){
                if (graph[i][k] + graph[k][j] < graph[i][j]){
                    graph[i][j] = graph[i][k] + graph[k][j]
                }
            }
        }
    }

    var min = 1e6

    for (i in 0 until n)
        for (j in 0 until n)
            if (i != j && graph[i][j] < min)
                min = graph[i][j]

    println(min.toInt())
}