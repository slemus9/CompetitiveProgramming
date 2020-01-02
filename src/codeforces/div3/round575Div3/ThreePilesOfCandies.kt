package codeforces.div3.round575Div3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    for (i in 1 .. n){
        val piles = br.readLine().trim().split(" ").map { it.toLong() }
        val sum = piles.fold(0L)  {x, y -> x + y}
        println(sum/2)
    }
}