package codeforces.div2.round610

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

data class Constraint(val hard: Long, val easy: Long, val time: Long)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().toInt()

    for (i in 0 until m){
        val (n, T, a, b) = br.readLine().split(" ").map { it.toLong() }
        val hard = br.readLine().split(" ").map { it.toLong() }
        val t = br.readLine().split(" ").map { it.toLong() }
        val problems = scanConstraints((t zip hard).sortedBy { (t, _) -> t }, T)
        val calcMax = calculateMaxPoints(a, b, problems.last().easy, problems.last().hard)
        println(problems.zipWithNext().map { (prev, next) -> calcMax(prev, next.time - 1) }.max())
    }


}

fun calculateMaxPoints(a: Long, b:Long, totalEasy: Long, totalHard: Long): (required: Constraint, time: Long) -> Long =
    { (hard, easy), time ->
        val needed = easy * a + hard * b
        if (needed > time) 0
        else{
            val remEasy = totalEasy - easy
            val remHard = totalHard - hard
            val time2Easy = time - needed
            val posEasy = min(remEasy, time2Easy/a)
            val time2Hard = time2Easy - posEasy * a
            val posHard = min(remHard, time2Hard/b)
            easy + hard + posEasy + posHard
        }
    }


fun scanConstraints(list: List<Pair<Long, Long>>, t: Long): List<Constraint> {
    var prev = Constraint(0,0,0);
    val result = mutableListOf<Constraint>()
    result.add(prev)
    list.forEach { (time, isHard) ->
        val (hard, easy, timePrev) = prev
        val newItem = when(isHard){
            1L -> Constraint(hard + 1, easy, time)
            else -> Constraint(hard, easy + 1, time)
        }
        if(timePrev == time && result.isNotEmpty()){
            result[result.size - 1] = newItem
        } else {
            result.add(newItem)
        }
        prev = newItem
    }
    result.add(prev.copy(time = t + 1))
    return result
}