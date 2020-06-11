package codeforces.JuniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

object GoodNumber {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        var cnt = 0
        for (i in 1 .. n) {
            var num = br.readLine().toInt()
            if ((0..k).all { it in getDigits(num).toSet() }){
                cnt++
            }
        }
        println(cnt)
    }

    fun getDigits (n: Int): List<Int> {
        tailrec fun go (n: Int, acc: ArrayList<Int>): ArrayList<Int> =
            if (n == 0) acc
            else go(n/10, acc.apply { add(n % 10) })
        return go(n, ArrayList())
    }

}