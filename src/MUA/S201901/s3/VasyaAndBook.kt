package MUA.S201901.s1.s3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

object VasyaAndBook{

    fun stepsToPage(n: Int, x: Int, y: Int, d: Int): Int{
        val xmodd = x % d
        val ymodd = y % d

        if (xmodd == ymodd){
            return (y - x).absoluteValue / d
        }else{
            val firstMod = 1 % d
            val lastMod = n % d
            var minSteps = -1

            if(firstMod == ymodd){
                val xToBeg = ((x - 1) / d) + 1
                val begToY = (y - 1) / d
                minSteps = xToBeg + begToY
            }
            if(lastMod == ymodd){
                val xToEnd = ((n - x) / d) + 1
                val endToY = (n - y) / d
                val total = xToEnd + endToY

                if (minSteps == -1 || minSteps > total){
                    minSteps = total
                }

            }
            return minSteps
        }


    }

}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 1 .. t){
        val nums = br.readLine().trim().split(" ").map { it.toInt() }
        val n = nums[0]
        val x = nums[1]
        val y = nums[2]
        val d = nums[3]
        println(VasyaAndBook.stepsToPage(n, x, y, d))
    }
}