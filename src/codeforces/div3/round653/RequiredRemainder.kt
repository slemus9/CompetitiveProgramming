import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t) {
        val (x, y, n) = br.readLine().split(" ").map { it.toInt() }
        val k = n/x
        println(
            if (x*k + y <= n) x*k + y
            else x*(k - 1) + y
        )
    }
}