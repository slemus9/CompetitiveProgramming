package codeforces.juniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun readNums () = br.readLine().split(" ").map { it.toDouble() }
    val x = readNums().drop(1).max()!!
    val y = readNums().drop(1).max()!!
    val z = readNums().drop(1).min()!!
    val (A, B) = readNums()
    val ans = x * sqrt((B*y)/(B*y + A*z))
    println("%.12f".format(ans))
}