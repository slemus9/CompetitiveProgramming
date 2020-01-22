package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    println(dangerous(s))
}

fun dangerous (s: String): String{
    tailrec fun go (s: String, cnt: Int, prev: Int): String =
        if (cnt == 7) "YES"
        else if (s.isEmpty()) "NO"
        else {
            val num = s.first() - '0'
            if (num == prev) go(s.drop(1), cnt + 1, num)
            else go(s.drop(1), 1, num)
        }
    return go(s.drop(1), 1, s.first() - '0')
}