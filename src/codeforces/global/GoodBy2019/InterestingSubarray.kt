package codeforces.global.GoodBy2019

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val n = br.readLine().toInt()
        val a = (br.readLine().split(" ").map { it.toInt() }.zipWithNext() zip (0 until n)).dropWhile {
            (adj, index) ->
                val (fst, snd) = adj
                abs(fst - snd) < 2
        }

        if (a.isNotEmpty()){
            println("YES")
            val from = a.first().second + 1
            val to = from + 1
            println("$from $to")
        }else{
            println("NO")
        }
    }
}
