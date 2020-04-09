package MUA.S201901.s1.s3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

object MaximumWeightDifference{

    fun diff(nums: List<Int>, n: Int, k: Int, kFirst: Boolean): Int{

        var sumFather = 0
        var sumChild = 0
        var j = 0
        var childUntil = 0

        if (kFirst){
            childUntil = k
        }else{
            childUntil = n - k
        }

        while (j < childUntil){
            sumChild += nums[j]
            j++
        }

        while (j < n){
            sumFather += nums[j]
            j++
        }
        return sumFather - sumChild
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()


    for (i in 0 until t){
        val nk = br.readLine().split(" ").map { it.toInt() }
        val nums = br.readLine().split(" ").map { it.toInt() }.sorted()

        var diffKFirst = MaximumWeightDifference.diff(nums, nk[0], nk[1], true)
        var diffKLast = MaximumWeightDifference.diff(nums, nk[0], nk[1], false)

        println(max(diffKFirst, diffKLast))
    }

}