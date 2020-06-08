package codeforces.div3.round575

import java.io.BufferedReader
import java.io.InputStreamReader

object OddSumSegments {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val q = br.readLine().toInt()

        for (i in 1 .. q){
            val (n, k) = br.readLine().split(" ").map { it.toInt() }
            val a = br.readLine().split(" ").map { it.toInt() }
            val numOdd = a.filter { it % 2 == 1 }.size

            if (numOdd < k || (numOdd - k) % 2 == 1) {
                println("NO")
            } else {
                println("YES")
                val r = a.zip(1..n).filter { it.first % 2 == 1 }.unzip().second.take(k - 1) + listOf(n)
                println(r.joinToString(" "))
            }
        }
    }
}

fun main() {
    OddSumSegments.main()
}