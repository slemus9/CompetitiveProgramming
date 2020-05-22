package codeforces.div2.round578

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun canJump(from: Int, to: Int, k: Int): Boolean =
        abs(from - to) <= k

fun takeMaxBlocks(from: Int, to: Int, k: Int): Int =
        min(from - to + k, from)

fun putMinBlocks(from: Int, to: Int, k: Int): Int =
        to - from - k

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()


    for (i in 1 .. t){
        val nmk = br.readLine().split(" ").map { it.toInt() }
        val cols = br.readLine().split(" ").map { it.toInt() }

        val n = nmk[0]
        var m = nmk[1]
        val k = nmk[2]
        var canPlay = true

        for (j in 0 until n - 1){

            val from = cols[j]
            val to = cols[j + 1]

            if (canJump(from, to, k)){
                m += takeMaxBlocks(from, to, k)
            }else {

                if(from > to)
                    m += takeMaxBlocks(from, to, k)
                else
                    m -= putMinBlocks(from, to, k)

                if (m < 0){
                    canPlay = false
                    break
                }
            }

        }

        println(
            if (canPlay)
                "YES"
            else
                "NO"
        )

    }
}