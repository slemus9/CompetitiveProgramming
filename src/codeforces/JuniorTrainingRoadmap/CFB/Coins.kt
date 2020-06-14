package codeforces.JuniorTrainingRoadmap.CFB

import java.io.BufferedReader
import java.io.InputStreamReader

object Coins {
    fun greater (comp: String): String {
        val (x, rel, y) = comp.chunked(1)
        return if (rel == ">") x else y
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val comps = List(3) { br.readLine() }
        val greatest = comps.map { greater(it) }
        if (greatest.sorted() == listOf("A", "B", "C")){
            println("Impossible")
        } else {
            val freqs = greatest.groupBy { it }.map { (letter, xs) -> letter to xs.size }
            val ans = listOf(
                (setOf("A", "B", "C") - greatest.toSet()).first(),
                freqs.filter { it.second == 1 }.first().first,
                freqs.filter { it.second == 2 }.first().first
            )
            println(ans.joinToString(""))
        }
    }
}
