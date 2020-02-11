package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val B = readMatrix(br, m)
    println(matrixToString(B))
    val A = buildA(B, m, n)
    val allZeroes =
        A.fold(true){acc, r -> acc && r.fold(true){acc, x -> acc && x == 0} }
    println(
        if (allZeroes){
            "NO"
        }else{
            "YES\n" + matrixToString(A)
        }
    )
}

fun buildA (B: List<List<Int>>, m: Int, n: Int): List<List<Int>>{
    val rowIndices = getRowIndices(B).toHashSet()
    val colIndices = getRowIndices(transpose(B)).toHashSet()
    val A = List(m){ List(n){0} }
    return A.mapIndexed {
            i, row -> row.mapIndexed {
                j, _ ->
                    if (i in rowIndices && j in colIndices) 1
                    else 0
            }
    }
}

fun getRowIndices (B: List<List<Int>>): List<Int>{
    val m = B.size
    tailrec fun go (i: Int, indices: List<Int>): List<Int> =
        if (i == m) indices
        else if (traverseRow(i, B)) go(i + 1, indices + i)
        else go(i + 1, indices)
    return go(0, emptyList())
}

fun traverseRow (i: Int, B: List<List<Int>>): Boolean =
    B[i].dropLastWhile { x -> x == 1 }.isEmpty()


fun transpose (M: List<List<Int>>): List<List<Int>> {
    tailrec fun go (M: List<List<Int>>, MT: List<List<Int>>): List<List<Int>> =
        if (M.first().isEmpty()) MT
        else go(M.map { it.drop(1) }, (MT + M.map { it.first() }) as List<List<Int>>)
    return go(M, emptyList())
}

fun matrixToString (M: List<List<Int>>): String =
    M.fold(""){acc, r -> "$acc\n" + r.joinToString("")}.dropLast(1)

fun readMatrix (br: BufferedReader, m: Int): List<List<Int>>{
    tailrec fun go (i: Int, B: List<List<Int>>): List<List<Int>> =
        if (i == m) B
        else go(i + 1, (B + br.readLine().split(" ").map { it.toInt() }) as List<List<Int>>)
    return go(1, emptyList<List<Int>>())
}