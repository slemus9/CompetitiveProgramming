package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet

object SnackTower {
    fun getStacked (snacks: List<Int>): List<List<Int>> =
        snacks.fold(Triple(Stack<List<Int>>(), HashSet<Int>(), snacks.size)){(acc, stored, maxSoFar), x ->
            val newStored = stored.apply { add(x) }
            val toStack = (maxSoFar downTo 1).takeWhile { it in newStored }
            val newAcc = acc.apply { add(toStack) }
            Triple(newAcc, newStored, maxSoFar - toStack.size)
        }.first

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val snacks = br.readLine().split(" ").map { it.toInt() }
        getStacked(snacks).forEach { xs -> println(xs.joinToString(" ")) }
    }
}

fun main() {
    SnackTower.main()
}
