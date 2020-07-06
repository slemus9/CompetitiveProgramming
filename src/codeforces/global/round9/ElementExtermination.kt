package codeforces.global.round9

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val a = br.readLine().split(" ").map { it.toInt() }
        var j = 1
        var k = 0
        var possible = true

        while (j < n && possible) {
            while (j < n && a[0] < a[j]) {
                j ++
            }
            if (j < n) {
                k = j + 1
                while (k < n && a[j] >= a[k]) {
                    k++
                }
                if (k >= n) {
                    possible = false
                } else {
                    j = k
                }
            }
        }
        println(
                if (possible) "YES" else "NO"
        )
    }
}