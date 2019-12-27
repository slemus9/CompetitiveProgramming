package codeforces.exercises

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min


/**
 * https://codeforces.com/problemset/problem/1265/B
 */
fun main() {
    val br = FastReader()
    val t = br.nextInt()

    for (i in 1..t){
        val n = br.nextInt()
        val pos = Array(n + 1){_ -> 0}

        for (i in 0 until n){
            pos[br.nextInt()] = i
        }

        println(findBeautifulNumbers(pos))
    }

}

fun findBeautifulNumbers(pos: Array<Int>): String{
    tailrec fun go(i: Int, minPos: Int, maxPos: Int, res: String): String =
        if (i == pos.size) res
        else{
            val newMax = max(maxPos, pos[i])
            val newMin = min(minPos, pos[i])
            if (newMax - newMin == i - 1){
                go(i + 1, newMin, newMax, res + '1')
            }else{
                go(i + 1, newMin, newMax, res + '0')
            }
        }
    return go(1, Int.MAX_VALUE, 0, "")
}

internal class FastReader {
    var br: BufferedReader
    var st: StringTokenizer? = null
    operator fun next(): String {
        while (st == null || !st!!.hasMoreElements()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt(): Int {
        return next().toInt()
    }

    fun nextLong(): Long {
        return next().toLong()
    }

    fun nextDouble(): Double {
        return next().toDouble()
    }

    fun nextLine(): String {
        var str = ""
        try {
            str = br.readLine()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return str
    }

    init {
        br = BufferedReader(InputStreamReader(System.`in`))
    }
}