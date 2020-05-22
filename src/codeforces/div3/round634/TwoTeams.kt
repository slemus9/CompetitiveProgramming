package codeforces.div3.round634

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

object TwoTeams {

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t){
            val n = br.readLine().toInt()
            val a = br.readLine().split(" ").map { it.toInt() }
            val groups = a.groupBy { it }.toList()
            val unique = groups.size
            val maxRepeated = groups.fold(0){
                acc, (_, group) -> max(acc, if (group.size > 1) group.size else acc)
            }
            println(
                if (n == 1) 0
                else if (unique == n) 1
                else {
                    max(min(unique - 1, maxRepeated), min(unique, maxRepeated - 1))
                }
            )
        }
    }
}

fun main() {
    TwoTeams.main()
}