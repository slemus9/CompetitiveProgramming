package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val changeCase = {c: Char -> if (c.isUpperCase()) c.toLowerCase() else c.toUpperCase()}

    val capsLock =
        if (s[0].isLowerCase())
            s.drop(1).dropWhile { it.isUpperCase() }
        else
            s.dropWhile { it.isUpperCase() }

    println(
        if (capsLock.isNotEmpty()) s
        else s.map { c -> changeCase(c) }.joinToString("")
    )
}