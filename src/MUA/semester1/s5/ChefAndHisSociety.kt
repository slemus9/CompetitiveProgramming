package MUA.semester1.s1.s5

import java.io.BufferedReader
import java.io.InputStreamReader

object ChefAndHisSociety{
    fun searchMinM (n: Int, th: Int, arr: List<Int>): Pair<Int, Int>{

        val searchArr = IntArray(arr.max()!!)
        var s = 0
        var m = 0
        var i = 0
        var j = searchArr.size
        var found = false

        while (i <= j && !found){
            m = (j + i) / 2
            s = arr.fold(0) {x, xs -> x + (if (xs - m < 0) 0 else xs - m)}
            searchArr[m] = s
            if (s > th){
                i = m + 1
            }else if (s < th){
                j = m - 1
            }else{
                found = true
            }
        }

        return if(!found) j to searchArr[j] else m to searchArr[m]

    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().trim().toInt()

    for (i in 0 until t){
        val nums = br.readLine().trim().split(" ").map { it.toInt() }
        val n = nums[0]
        val th = nums[1]
        val arr = br.readLine().trim().split(" ").map { it.toInt() }
        val (m, sum) = ChefAndHisSociety.searchMinM(n, th, arr)
        println("$m $sum")
    }

}