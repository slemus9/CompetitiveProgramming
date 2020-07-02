import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t) {
        val n = br.readLine().toInt()
        val s = br.readLine()
        var cnt = 0
        var moves = 0
        for (c in s) {
            when (c) {
                '(' -> cnt ++
                else -> {
                    if (cnt == 0) {
                        moves++
                    } else {
                        cnt--
                    }
                }
            }
        }
        println(cnt)
    }
}