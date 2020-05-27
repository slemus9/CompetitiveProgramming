package codeforces.div3.round644

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

object SpyString {
    fun are1CharAway (s1: String, s2: String): Boolean =
        s1.zip(s2).fold(0){diffs, (s1_i, s2_i) ->
            diffs + if (s1_i != s2_i) 1 else 0
        } <= 1

    fun checkString (s: String, strings: List<String>): Boolean =
        strings.dropWhile { s_i -> are1CharAway(s_i, s) }.isEmpty()

    fun solve (strings: List<String>) {
        var ans = StringBuilder("")
        val m = strings[0].length
        var found = false
        var i = 0
        while (i < m && !found) {
            ans = StringBuilder(strings[0])
            var c = 'a'
            while (c <= 'z' && !found) {
                ans[i] = c
                found = checkString(ans.toString(), strings)
                c++
            }
            i++
        }
        if (found) {
            println(ans)
        } else {
            println(-1)
        }
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()
        for (i in 1 .. t) {
            val (n, m) = br.readLine().split(" ").map { it.toInt() }
            val strings = List(n){br.readLine()}
            solve(strings)
        }
    }
}

fun main() {
    SpyString.main()
}

