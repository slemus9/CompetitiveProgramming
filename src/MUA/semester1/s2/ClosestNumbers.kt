package MUA.semester1.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

object ClosestNumbers {

    fun minDiff(lst: List<Int>): List<Int>{
        var minD = Int.MAX_VALUE
        var candidates = arrayListOf<Int>()

        for (i in 1 until lst.size){
            val currentDiff = (lst[i - 1] - lst[i]).absoluteValue
            when {
                currentDiff < minD -> {
                    minD = currentDiff
                    candidates = arrayListOf(lst[i - 1], lst[i])
                }
                currentDiff == minD -> {
                    candidates.addAll(arrayOf(lst[i - 1], lst[i]))
                }
            }
        }

        return candidates
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val numbers = br.readLine().trim().split(" ").map { it.toInt() }.sorted()
    println(ClosestNumbers.minDiff(numbers).joinToString(" "))
}