package codeforces.div4.round640

import java.io.BufferedReader
import java.io.InputStreamReader

object SameParitySummands {

    fun odd (x: Int) = x % 2 == 1
    fun even (x: Int) = x % 2 == 0

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t) {
            val (n, k) = br.readLine().split(" ").map { it.toInt() }

            if (odd(n) && even(k) || k > n){
                println("NO")
            } else {

                if ((even(n) && even(k)) || (odd(n) && odd(k))) {
                    println("YES")
                    println("1 ".repeat(k - 1) + "${n - (k - 1)}")
                } else if ((even(n) && odd(k)) && !(even(n) && 2*k > n )) {
                    println("YES")
                    println("2 ".repeat(k - 1) + "${n - 2*(k - 1)}")
                } else {
                    println("NO")
                }
            }

        }
    }
}

fun main() {
    SameParitySummands.main()
}