package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

fun getAdj (M: List<String>, c: Char, i: Int, j: Int): List<Char>{
    val n = M.size
    val m = M[0].length
    val adj = ArrayList<Char>()
    if (j > 0 && M[i][j - 1] != c){
        adj.add(M[i][j - 1])
    }
    if (j < m - 1 && M[i][j + 1] != c){
        adj.add(M[i][j + 1])
    }
    if (i > 0 && M[i - 1][j] != c){
        adj.add(M[i - 1][j])
    }
    if (i < n - 1 && M[i + 1][j] != c){
        adj.add(M[i + 1][j])
    }
    return adj
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nmc = br.readLine().split(" ")
    val n = nmc[0].toInt()
    val m = nmc[1].toInt()
    val c = nmc[2].toCharArray()[0]
    val office = List(n){br.readLine()}

    val seen = HashSet<Char>()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (office[i][j] == c){
                seen.addAll(getAdj(office, c, i, j))
            }
        }
    }
    println(
        if ('.' in seen) seen.size - 1
        else seen.size
    )
}