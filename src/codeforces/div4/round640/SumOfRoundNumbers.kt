package codeforces.div4.round640

import java.io.BufferedReader
import java.io.InputStreamReader

object SumOfRoundNumbers {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t) {
            var n = br.readLine().toInt()
            var cnt = 1
            val numbers = mutableListOf<Int>()
            while (n > 0) {
                val d = n % 10
                n /= 10
                numbers.add(d * cnt)
                cnt *= 10

            }
            val ans = numbers.filter { it != 0 }
            println(ans.size)
            println(ans.joinToString(" "))
        }
    }
}

fun main() {
    SumOfRoundNumbers.main()
}