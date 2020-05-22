package codeforces.div2.round610

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t){
        val abcr = br.readLine().split(" ").map { it.toInt() }
        val a = abcr[0]
        val b = abcr[1]
        val c = abcr[2]
        val r = abcr[3]

        val start = min(a, b)
        val end = max(a, b)
        val startR = c - r
        val endR = c + r
        if (intersects(start to end, startR to endR)){
            println("${max(startR - start,0) + max(end - endR,0)}")
        }else{
            println(end - start)
        }

    }
}

fun intersects(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Boolean{
    val (p1start, p1end) = p1
    val (p2start, p2end) = p2
    return (p1start >= p2start && p1start <= p2end) || (p2start >= p1start && p2start <= p1end)
}