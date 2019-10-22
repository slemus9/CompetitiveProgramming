package MUA.semester1.s1.s3

import java.io.BufferedReader
import java.io.InputStreamReader

object ArrayStabilization{

    fun arrayInstability(arr: List<Int>): Int? =
            if (arr.size == 2) 0
            else arrayOf(arr.last() - arr[1], arr[arr.size - 2] - arr.first()).min();
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted()
    println(ArrayStabilization.arrayInstability(arr))

}