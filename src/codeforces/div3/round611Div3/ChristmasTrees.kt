package codeforces.div3.round611Div3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val x = br.readLine().split(" ").map { it.toInt() }
    val distances = HashMap<Int, Int>()

    for (xi in x){
        distances[xi] = 0
    }
}