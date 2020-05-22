package codeforces.div2.round580

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun countOps(coins: List<Long>): Long{
    var count = 0L
    for (c in coins){
        if (c == 0L) count++
        else count += abs(c) - 1
    }
    return count
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val coins = br.readLine().split(" ").map { it.toLong() }
    var count = countOps(coins)
    var countNeg = 0L
    var countZeroes = 0L

    for (c in coins){
        if (c == 0L) countZeroes++
        else if (c < 0) countNeg ++
    }




    println(
            if (countNeg % 2 != 0L && countZeroes == 0L) count + 2 else count
    )
}