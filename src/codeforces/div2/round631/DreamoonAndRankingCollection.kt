package codeforces.div2.round631

import java.io.BufferedReader
import java.io.InputStreamReader

object DreamoonAndRankingCollection {

    fun count (a: List<Int>): Array<Int>{
        val count = Array(210){0}
        for (a_i in a){
            count[a_i]++
        }
        return count
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t){
            val (n, x) = br.readLine().split(" ").map { it.toInt() }
            val a = br.readLine().split(" ").map { it.toInt() }
            val count = count(a)
            count[0] = 1
            var canObtain = 0

            for (i in count.indices){
                if (count[i] == 0){
                    count[i] = 1
                    canObtain++
                    if (canObtain == x){
                        break
                    }
                }
            }
            println(count.zip(count.indices).dropWhile { (c, _) -> c >= 1 }.first().second - 1)
        }
    }
}

fun main() {
    DreamoonAndRankingCollection.main()
}