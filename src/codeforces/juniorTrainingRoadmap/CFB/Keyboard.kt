package codeforces.juniorTrainingRoadmap.CFB


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, x) = br.readLine().split(" ").map { it.toInt() }
    val keyboard = List(n){br.readLine()}
    br.readLine()
    val q = br.readLine()
    val keys = HashSet<Char>()
    val oneHand = HashSet<Char>()
    val twoHands = HashSet<Char>()
    val shifts = HashSet<Pair<Int, Int>>()

    for (i in keyboard.indices) for (j in keyboard[i].indices) {
        val key = keyboard[i][j]
        if ( key == 'S') shifts.add(i + 1 to j + 1)
        else keys.add(key)
    }

    if (shifts.isNotEmpty()){
        for (i in keyboard.indices) for (j in keyboard[i].indices) {
            val key = keyboard[i][j]
            if (key != 'S') {
                val (ci, cj) = i + 1 to j + 1
                val useOtherHand = shifts.all { (si, sj) ->
                    x*x < (si-ci)*(si-ci) + (sj-cj)*(sj-cj)
                }
                if (useOtherHand){
                    if (key !in oneHand) twoHands.add(key)
                    else twoHands.remove(key)
                }
                else {
                    oneHand.add(key)
                    twoHands.remove(key)
                }
            }
        }
    }

    var ans = 0
    for (c in q) {
        if (c.toLowerCase() !in keys) {
            ans = -1
            break
        } else{
            if (c.isUpperCase()) {
                if (shifts.isEmpty()) {
                    ans = -1
                    break
                }
                if (c.toLowerCase() in twoHands) ans ++
            }
        }
    }
    println(ans)
}