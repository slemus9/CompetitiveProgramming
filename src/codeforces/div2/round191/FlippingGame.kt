package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").filter { x -> x != ""}.map { it.toInt() }

    val gains = Array(n){x -> 0}
    var initialOnes = 0

    for (ai in a){
        if (ai == 1) initialOnes++
    }


    if(initialOnes == n){
        println(initialOnes - 1)
    }else{
        for (i in 0 until n){
            if (a[i] == 0) gains[i] = 1
            else gains[i] = -1
        }

        println(initialOnes + maxSubarray(gains))
    }

}

fun maxSubarray(gains: Array<Int>): Int{
    var maxSum = 0
    var currSum = 0

    for (g in gains){
        currSum = max(currSum + g, 0)
        maxSum = max(currSum, maxSum)
    }

    return maxSum
}