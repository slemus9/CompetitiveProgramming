package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

sealed class Result {
    companion object {
        val FAILURE = Failure()
    }
    data class Success(val value: Int):Result()
    class Failure():Result()
}

var a = 0
var b = 0
var c = 0
val map = mutableMapOf<Pair<List<Int>, Int>, Result>()

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nabc = br.readLine().split(" ").map { it.toInt() }
    val n = nabc[0]
    val ribbons = nabc.drop(1)
    val ans = findMaxPieces(ribbons, n)

    println(if (ans is Result.Success) ans.value else -1)

}

fun findMaxPieces(ribbons: List<Int>, n: Int): Result{
    val key = ribbons to n
    if (key in map) return map[key]!!

    val result = if (n == 0){
        Result.Success(0)
    }
    else if (n < 0){
        Result.FAILURE
    }
    else if (ribbons.isEmpty()) {
        Result.FAILURE
    } else {
        val left = findMaxPieces(ribbons, n - ribbons[0])
        val right = findMaxPieces(ribbons.drop(1), n)
        if (left is Result.Failure && right is Result.Failure)
            Result.FAILURE
        else if (left is Result.Failure)
            right
        else if (right is Result.Failure && left is Result.Success)
            Result.Success(left.value + 1)
        else if(left is Result.Success && right is Result.Success)
            Result.Success(max(left.value + 1, right.value))
        else
            Result.FAILURE
    }
    map[key] = result
    return result

}