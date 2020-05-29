package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://codeforces.com/problemset/problem/1271/B
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val blocks = br.readLine().map { c -> if (c == 'B') 1 else 0 }.toTypedArray()
    val sum = blocks.sum()


    if (sum == 0 || sum == n){
        println(0)
    }else if (n % 2 == 0 && sum % 2 != 0){
        println(-1)
    }else{

        val favColor = 1
        val blocksCopy = blocks.copyOf()
        var result = colorize(favColor, blocks)

        if (!result.first){
            result = colorize(swapColor(favColor), blocksCopy)
        }

        val indices = result.second

        println(indices.size)
        var ans = ""
        for (i in indices){
            ans += "$i "
        }
        ans.trim()
        println(ans)
    }
}

fun swapColor(color: Int) = if (color == 1) 0 else 1


fun colorize(favColor: Int, blocks: Array<Int>): Pair<Boolean, MutableList<Int>>{
    val indices = mutableListOf<Int>()
    val n = blocks.size
    for (i in 0 until n - 1){
        if (blocks[i] != favColor){
            blocks[i] = swapColor(blocks[i])
            blocks[i + 1] = swapColor(blocks[i + 1])
            indices += i + 1
        }
    }

    return Pair(blocks[n - 1] == favColor, indices)
}