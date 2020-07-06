package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    var i = 0
    var j = 2
    val ans = StringBuilder()
    while (i < s.length) {
        if (j >= s.length) {
            ans.append(s.substring(i))
            i = s.length
        } else if (s.substring(i..j) == "WUB"){
            if (ans.isNotEmpty() && ans.last() != ' '){
                ans.append(' ')
            }
            i = j + 1
            j += 3
        } else {
            ans.append(s[i])
            i++
            j++
        }
    }

    println(ans.trim())
}