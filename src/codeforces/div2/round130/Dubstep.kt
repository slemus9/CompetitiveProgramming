package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val noIniWUB = s.replace("""^(WUB)+""".toRegex(), "")
    val middle = noIniWUB.replace("""(WUB)+$""".toRegex(), "")
    println(middle.replace("""(WUB)+""".toRegex(), " "))
}
