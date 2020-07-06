package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

object ChewbaccaAndNumber {
    fun getDigits (n: Long): List<Int> {
        tailrec fun go (n: Long, acc: ArrayList<Int>): ArrayList<Int> =
            if (n == 0L) acc
            else go (n/10, acc.apply { add((n % 10).toInt()) })
        return go(n, ArrayList()).reversed()
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var x = br.readLine().toLong()
        val digits = getDigits(x)
        val ans = ArrayList<Int>()
        digits.forEach { digit ->
            if ((digit == 9 && ans.isEmpty()) || digit < 5) {
                ans.add(digit)
            } else {
                ans.add(9 - digit)
            }
        }
        println(ans.joinToString(""))
    }
}