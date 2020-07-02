import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1 .. t) {
        var n = br.readLine().toInt()
        var a = 0
        var b = 0
        while (n % 3 == 0) {
            a++
            n/=3
        }
        while (n % 2 == 0) {
            b++
            n/=2
        }
        val isValid = n == 1 && a >= b
        println(
            if (isValid) a + (a - b)
            else -1
        )
    }
}