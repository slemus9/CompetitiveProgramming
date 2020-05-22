package codeforces.div2.round637

import java.io.BufferedReader
import java.io.InputStreamReader

object NastyaAndRice {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t) {
            val (n, a, b, c, d) = br.readLine().split(" ").map { it.toInt() }

            println(
                if (n*(a - b) <= c + d && n*(a + b) >= c - d) "Yes"
                else "No"
            )
        }
    }
}

fun main() {
    NastyaAndRice.main()
}