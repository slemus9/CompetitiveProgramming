package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var G = mutableMapOf<Int, ArrayList<Int>>()
    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        G[u] = G.getOrDefault(u, ArrayList()).apply { add(v) }
        G[v] = G.getOrDefault(v, ArrayList()).apply { add(u) }
    }

    var toDelete = G.filter { it.value.size == 1 }.keys
    var cnt = 0
    while (toDelete.isNotEmpty()) {
        cnt++
        toDelete.forEach { G.remove(it) }
        G.forEach { _, xs -> xs.removeAll(toDelete)}
        toDelete = G.filter { it.value.size == 1 }.keys
    }
    println(cnt)
}