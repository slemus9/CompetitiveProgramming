package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val B = readMatrix(br, m)

}

fun traverseRowAndColumn (i: Int, j: Int, B: List<List<Int>>): Boolean =
    B[i].dropLastWhile { x -> x == 1 }.isEmpty() &&
            transpose(B)[j].dropWhile { x -> x == 1 }.isEmpty()

fun transpose (M: List<List<Int>>): List<List<Int>> {
    tailrec fun go (M: List<List<Int>>, MT: List<List<Int>>): List<List<Int>> =
        if (M.first().isEmpty()) MT
        else go(M.map { it.drop(1) }, (MT + M.map { it.first() }) as List<List<Int>>)
    return go(M, emptyList())
}

fun readMatrix (br: BufferedReader, m: Int): List<List<Int>>{
    tailrec fun go (i: Int, B: List<List<Int>>): List<List<Int>> =
        if (i == m) B
        else go(i + 1, (B + br.readLine().split(" ").map { it.toInt() }) as List<List<Int>>)
    return go(1, emptyList())
}