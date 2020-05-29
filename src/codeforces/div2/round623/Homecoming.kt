package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    Homecoming.main()
}

object Homecoming {

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()


        for (i in 0 until t){
            val (a, b, p) = br.readLine().split(" ").map { it.toLong() }
            val s = br.readLine()
            val costs = getAccCosts(s, a, b)
            val canAfford = costs.dropWhile { (_ , sum) -> p < sum}
            println(
                if (canAfford.isEmpty()) s.length
                else canAfford[0].first + 1
            )
        }
    }

    fun getAccCosts (s: String, a: Long, b: Long): List<Pair<Int, Long>>{
        val n = s.length
        val costs = arrayListOf<Long>()
        val indices = arrayListOf<Int>()
        indices.add(0)
        var i = 1
        var prevEqual = s[0]

        while (i < n - 1){
            if (s[i] != prevEqual){
                prevEqual = s[i]
                indices.add(i)
            }
            i++
        }

        var j = indices.size - 1
        var sum = 0L

        while (j >= 0){
            val idx = indices[j]
            sum += if (s[idx] == 'A') a else b
            costs.add(sum)
            j--
        }

        return indices zip costs.reversed()
    }
}