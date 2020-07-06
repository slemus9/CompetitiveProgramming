package codeforces.juniorTrainingRoadmap.CFA

import java.io.BufferedReader
import java.io.InputStreamReader

object TeamOlympiad {
    private fun <A> zip3 (xs: List<A>, ys: List<A>, zs: List<A>) =
        xs.zip(ys).zip(zs) {(x, y), z -> listOf(x, y, z)}

    private fun filterBySkill (students: List<Pair<Int, Int>>, skill: Int) =
        students.filter {(s, _) -> s == skill}.map { it.second }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val t = br.readLine().split(" ").map { it.toInt() }.zip(1..n)
        val teams = zip3(
            filterBySkill(t, 1),
            filterBySkill(t, 2),
            filterBySkill(t, 3)
        )
        println(teams.size)
        teams.forEach {team ->
            println(team.joinToString(" "))
        }
    }
}

fun main() {
    TeamOlympiad.main()
}
