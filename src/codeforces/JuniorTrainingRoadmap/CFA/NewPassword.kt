package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val numBlocks = n / k
    val rem = n % k
    val block = ('a' .. ('a' + k - 1)).joinToString("")
    val remBlock = ('a' .. ('a' + rem - 1)).joinToString("")
    println(block.repeat(numBlocks) + remBlock)
}