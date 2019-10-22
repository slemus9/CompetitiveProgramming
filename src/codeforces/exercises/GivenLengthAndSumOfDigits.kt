package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val ms = br.readLine().split(" ").map { it.toInt() }
    val m = ms[0]
    val s = ms[1]

    if (s == 0){
        println(if (m == 1) "0 0" else "-1 -1")
    }else{

        if (s < 10){
            if (m == 1){
                println("$s $s")
            }else{
                val maxNum = s.toString() + "0".repeat(m - 1)
                val minNum = "1" + "0".repeat(m - 2) + (s - 1).toString()
                println("$minNum $maxNum")
            }

        } else if (s == 0 || m*9 < s){
            println("-1 -1")
        } else{

            val ans = getMinAndMax(m, s)

            println("${ans.first} ${ans.second}")

        }

    }

}

fun getMinAndMax(m: Int, s: Int): Pair<String, String>{
    val num9s = s / 9
    val missing = m - num9s
    val nines = if (missing >= 2 && s % 9 == 0) "9".repeat(num9s - 1) else "9".repeat(num9s)
    val minNum: String
    val maxNum: String

    val d = if (s - 9*num9s == 0) 9 else s - 9*num9s

    if (missing == 0){
        minNum = nines
        maxNum = nines
    } else if (missing <= 1){
        minNum = d.toString() + nines
        maxNum = nines + d.toString()
    }else{
        val l = 1
        val h = (d - 1)
        val zeroes = "0".repeat(if (s % 9 == 0) missing - 1 else missing - 2)

        minNum = l.toString() + zeroes + h + nines
        maxNum = nines + d.toString() + zeroes + "0"
    }
    return Pair(minNum, maxNum)
}