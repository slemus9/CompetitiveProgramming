package codeforces.div2.round631Div2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

object DreamoonLikesColoring {

//    fun paintCells (l: List<Long>, n: Long): List<Long>{
//        val m = l.size
//        val p = (0L until m).toMutableList()
//        var pos = n - 1L
//        for (i in m - 1 downTo 0){
//            while (p[i] + l[i] - 1 < pos){
//                p[i]++
//            }
//            pos = pos - l[i]
//        }
//        return p.map { it + 1 }
//    }

    fun sum (l: List<Long>): List<Long>{
        val sum = l.toMutableList()
        val m = l.size
        for (i in m - 2 downTo 0)
            sum[i] += sum[i + 1]
        return sum
    }

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toLong() }
        val l = br.readLine().split(" ").map { it.toLong() }
        val possible = l.zip(0 until m).dropWhile { (l_i, i) -> i <= n - l_i}.isEmpty()

        if (l.sum() < n || !possible){
            println(-1)
        } else{
            val sum = sum(l)
            println(
                (1 .. m).map { i -> max(i, n - sum[i.toInt() - 1] + 1) }.joinToString(" ")
            )
        }
    }
}

fun main() {
    DreamoonLikesColoring.main()
}