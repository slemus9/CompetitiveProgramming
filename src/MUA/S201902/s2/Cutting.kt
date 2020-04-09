package MUA.S201902.s2

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://codeforces.com/problemset/problem/998/B
 */
var N = 0
var B = 0



fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nb = br.readLine().split(" ").map { it.toInt() }
    N = nb[0]
    B = nb[1]

    val a = br.readLine().split(" ").map { it.toInt() }.toTypedArray()


}