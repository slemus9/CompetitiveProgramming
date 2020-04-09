package MUA.S201901.s1.s9

import java.io.BufferedReader
import java.io.InputStreamReader


var maze: Array<CharArray> = emptyArray()
var m = 0
var n = 0

fun <A, B, C, D> memo1(f: (A, B, C) -> D): (A, B, C) -> D {
    val vals = mutableMapOf<Triple<A, B, C>, D>()
    return {
        a: A, b: B, c: C -> vals.getOrPut(Triple(a, b, c)){f(a, b, c)}
    }
}

fun hasExit (x: Int, y: Int, s: Pair<Int, Int>): Boolean =
    if (maze[x][y] == '#') false

    else if ((x - 1) < 0 || (x + 1) > n || (y - 1) < 0 || (y + 1) > m) true
    else hasExit(x - 1, y, s) || hasExit(x + 1, y, s)
                || hasExit(x, y - 1, s) || hasExit(x, y + 1, s)


fun mazeHasOneExit (): Boolean{
    var countExits = 0
    var ans = false
    for (i in 0 until m){
        for (j in 0 until n){
            val hasExitij = memo1(::hasExit)(i, j, Pair(i, j))
            if (hasExitij) countExits ++
            if (countExits > 1) return false
        }
    }
    return countExits == 1
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val mn = br.readLine().split(" ").map { it.toInt() }
        m = mn[0]
        n = mn[1]
        maze = Array(m){CharArray(n)}

        for (i in 0 until m){
            maze[i] = br.readLine().toCharArray()
        }

        val ans = mazeHasOneExit()
        if (ans) println("valid")
        else print("invalid")
    }

}