package codeforces.kotlinHeroes.practice4

import java.io.BufferedReader
import java.io.InputStreamReader

object AliceBobAndCandies {

    fun main () {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t) {
            val n = br.readLine().toInt()
            val a = br.readLine().split(" ").map { it.toInt() }

            var alice = a[0]
            var bob = 0
            var accAlice = alice
            var accBob = bob

            var i = 1
            var j = a.size - 1
            var turn = 1

            while (i <= j){
                if (turn % 2 == 1){
                    bob = 0
                    while (j >= i && bob <= alice){
                        bob += a[j]
                        accBob += a[j]
                        j--
                    }
                    turn += 1
                } else {
                    alice = 0
                    while (i <= j && alice <= bob) {
                        alice += a[i]
                        accAlice += a[i]
                        i++
                    }
                    turn += 1
                }
            }

            println("$turn $accAlice $accBob")
        }
    }
}

fun main() {
    AliceBobAndCandies.main()
}