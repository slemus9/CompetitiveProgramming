package codeforces.Round580Div2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun countOps(coins: List<Long>): Long{
    var count = 0.toLong()
    for (c in coins){
        if (c == 0.toLong()) count++
        else count += abs(c) - 1
    }
    return count
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val coins = br.readLine().split(" ").map { it.toLong() }
    var count = countOps(coins)
    var countNeg = 0.toLong()
    var countZeroes = 0.toLong()

    for (c in coins){
        if (c == 0.toLong()) countZeroes++
        else if (c < 0) countNeg ++
    }




    println(
            if (countNeg % 2 != 0.toLong() && countZeroes == 0.toLong()) count + 2 else count
    )
}