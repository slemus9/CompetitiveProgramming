package codeforces.div2.round609

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nk = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine()
    val n = nk[0]
    val k = nk[1]
    val ans = Array(n){_ -> -1}

    var i = 0
    var j = k

    while (j < n && i < n){
        val num = (a[i] - '0')
        ans[i] = if (num == 9) 9 else num + 1
        ans[j] = if (num == 9) 9 else num + 1
        i++
        j = i + k
    }

    i = 0
    while (i < n){
        if (ans[i] == -1){
            ans[i] = (a[i] - '0')
        }
        i++
    }

    println(ans.foldRight(""){x, acc -> "$x" + acc})
}