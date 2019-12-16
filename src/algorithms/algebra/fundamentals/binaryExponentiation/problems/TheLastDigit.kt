package algorithms.algebra.fundamentals.binaryExponentiation.problems

/**
 * https://www.spoj.com/problems/LASTDIG/
 */
fun main(args: Array<String>) {
    val t = readLine()?.toInt()
    val zero = 0L
    for (i in 1 .. t!!){
        val ab = readLine()?.split(" ")!!.map { itL }
        var a = ab[0]
        var b = ab[1]
        var y: Long = 1
        if (b == zero) a = 1
        else{
            while (b > 1){
                if (b % 2 == zero) b /= 2
                else{
                    y = (y % 10 * a % 10) % 10
                    b = (b - 1)/2
                }
                a = (a % 10 * a % 10) % 10
            }
        }
        println((a*y) % 10)
    }
}