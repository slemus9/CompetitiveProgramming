package MUA.semester1.s2

import java.io.BufferedReader
import java.io.InputStreamReader

object ChefAndSorting {

    fun endSort(nums: List<Int>): Int{

        var count = 0
        val sortedList = nums.sorted()

        var i = 0
        var j = 0

        while(i < nums.size){
            if (nums[i] != sortedList[j]){
                count++
            }else{
                j++
            }
            i++
        }
        return count
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 1 .. t){
        val n = br.readLine().toInt()
        val nums = br.readLine().split(" ").map { it.toInt() }
        println(ChefAndSorting.endSort(nums))
    }
}