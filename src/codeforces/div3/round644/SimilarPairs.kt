package codeforces.div3.round644

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t) {
        val n = br.readLine().toInt()
        val a = br.readLine().split(" ").map { it.toInt() }
        val even = a.filter { it % 2 == 0}
        val numEven = even.size
        val numOdd = n - numEven

        if (numEven == 0 || numOdd == 0 || (numEven % 2 == 0 && numOdd % 2 == 0)) {
            println("YES")
        } else {
            val evenSet = even.toSet()
            val oddSet = a.filter { it % 2 == 1 }.toSet()
            var found = false
            for (x in evenSet) {
                if (x + 1 in oddSet || x - 1 in oddSet) {
                    found = true
                    break
                }
            }
            if (found) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}