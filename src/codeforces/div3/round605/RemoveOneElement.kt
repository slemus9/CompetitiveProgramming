package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

/**
 * http://codeforces.com/problemset/problem/1272/D
 */
object RemoveOneElement {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n by lazy { br.readLine().toInt() }
    val nums by lazy { br.readLine().split(" ").map { it.toInt() } }
    val incrL by lazy { buildIncrL() }
    val incrR by lazy { buildIncrR() }

    fun findMaxLengthSub(): Int{
        tailrec fun go(i: Int, maxSoFar: Int): Int =
            if (i == n - 2) maxSoFar
            else if (nums[i] < nums[i + 2]) go(i + 1, max(maxSoFar, incrL[i] + incrR[i + 2]))
            else go(i + 1, maxSoFar)
        return max( incrL.max()!!, go(0, 1) )
    }

    fun buildIncrL(): Array<Int>{
        val incr = Array(n){_ -> 1}
        for (i in 1 until n){
            if (nums[i] > nums[i - 1]){
                incr[i] += incr[i - 1]
            }
        }
        return incr
    }

    fun buildIncrR(): Array<Int>{
        val incrR = Array(n){_ -> 1}
        for (i in n - 2 downTo 0){
            if (nums[i] < nums[i + 1]){
                incrR[i] += incrR[i + 1]
            }
        }
        return incrR
    }
}

fun main() {
    println(RemoveOneElement.findMaxLengthSub())
}
