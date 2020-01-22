package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    println(saidHello(s))

}

fun saidHello (s: String): String{
    val hello = Stack<Char>()
    var countL = 0
    var i = 0

    while (i < s.length && !(hello.size == 5)){
        val c = s[i]
        if (c == 'h' && hello.isEmpty()){
            hello.push(c)
        } else if (hello.isNotEmpty() && c == 'e' && hello.peek() == 'h'){
            hello.push(c)
        } else if (hello.isNotEmpty() && c == 'l'){
            val lastChar = hello.peek()
            if (lastChar == 'e' || (lastChar == 'l' && countL < 2)) {
                hello.push(c)
                countL ++
            }
        } else if (hello.isNotEmpty() && c == 'o' && hello.peek() == 'l' && countL == 2){
            hello.push(c)
        }
        i++
    }

    return if (hello.size == 5) "YES" else "NO"
}
