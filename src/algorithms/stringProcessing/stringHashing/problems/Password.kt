package algorithms.stringProcessing.stringHashing.problems

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://codeforces.com/problemset/problem/126/B
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val n = s.length
    val lps = computeLps(s)

    var longest = lps[n - 1]

    if (longest == 0){
        println("Just a legend")
    }else{
        var i = 0
        var found = false

        while (i < n - 1 && !found){
            if (lps[i] == longest){
                found = true
            }
            i++
        }

        if (found){
            println(s.subSequence(0, longest))
        }else{
            val l = lps[longest - 1]
            if (l > 0){
                println(s.subSequence(0, l))
            }else{
                println("Just a legend")
            }
        }
    }

    
}

fun computeLps(s: String): Array<Int>{
    val n = s.length
    val lps = Array(n){_ -> 0}
    var len = 0
    var i = 1

    while (i < n){
        if (s[i] == s[len]){
            lps[i] = len + 1
            len++
            i++
        }else{
            if (len > 0){
                len = lps[len - 1]
            }else{
                lps[i] = 0
                i++
            }
        }
    }

    return lps
}