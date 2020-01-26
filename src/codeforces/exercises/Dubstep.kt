package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val n = s.length
    val wub = Stack<Char>()
    var ans = emptyList<Char>()
    var i = 0

    while (i < n){
        val c = s[i]
        if (c == 'W' && wub.isEmpty()){
            wub.push(c)
            ans += ' '
        } else if(c == 'U' && wub.isNotEmpty() && wub.peek() == 'W'){
            wub.push(c)
        } else if (c == 'B' && wub.isNotEmpty() && wub.peek() == 'U'){
            wub.push(c)
            wub.clear()
        } else{
            if (wub.isNotEmpty()){
                ans = ans.dropLast(1)
            }
            if (c != 'W') {
                ans += wub + c
                wub.clear()
            } else {
                if (wub.isEmpty()) wub.push(c)
                ans += wub
            }
        }
        i++
    }

    println(ans.joinToString("").trim())
}