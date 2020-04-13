package codeforces.div2.round631Div2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

object DreamoonLikesSequences {

    fun main (){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()

        for (i in 1 .. t){
            val (d, m) = br.readLine().split(" ").map { it.toLong() }
            val possibilities = (0 until 30).fold(1L){
                ans, i ->
                    if ((1 shl i) > d) ans
                    else ans*(min((1L shl (i + 1)) - 1, d) - (1 shl i) + 2) % m
            } - 1

            println(
                if (possibilities < 0) possibilities + m
                else possibilities
            )
        }
    }
}

fun main() {
    DreamoonLikesSequences.main()
}