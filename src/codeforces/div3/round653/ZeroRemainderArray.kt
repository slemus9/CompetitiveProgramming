import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for ( i in 1 .. t) {
        val (n, k) = br.readLine().split(" ").map { it.toLong() }
        val a = br.readLine().split(" ").map { it.toLong() }
        val count = HashMap<Long, Long>()
        var maxPair = 0L to 0L
        for (a_i in a) {
            val a_imod = a_i % k
            if (a_imod != 0L) {
                val count_i = count.getOrDefault(a_imod, 0) + 1
                if (count_i > maxPair.second) {
                    maxPair = a_imod to count_i
                } else if (count_i == maxPair.second && a_imod < maxPair.first) {
                    maxPair = a_imod to count_i
                }
                count[a_imod] = count_i
            }
        }
        println(
            if (maxPair.second == 0L) 0
            else k*(maxPair.second - 1) + k - maxPair.first + 1
        )
    }
}