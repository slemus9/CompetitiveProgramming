package codeforces.div4.round640

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.ceil

object KthNotDivisibleByN {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t) {
            val (n, k) = br.readLine().split(" ").map { it.toLong() }
            val windowSize = n - 1
            val windowOfAns = ceil(k.toDouble() / windowSize).toInt()
            val multipleBeforeAns = n * (windowOfAns - 1)
            val ans = multipleBeforeAns + (k - windowSize*(windowOfAns - 1))
            println(ans)
        }
    }
}

fun main() {
    KthNotDivisibleByN.main()
}