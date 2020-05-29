package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val vowels = hashSetOf('a', 'o', 'y', 'e', 'u', 'i', 'A', 'O', 'Y', 'E', 'U', 'I')
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val newS = s.filter { c -> !(c in vowels) }
                .map { c -> if (c.isUpperCase()) c.toLowerCase() else c}
                .joinToString(".")
    println(".$newS")
}