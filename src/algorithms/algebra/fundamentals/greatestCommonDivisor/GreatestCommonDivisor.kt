package algorithms.algebra.fundamentals.greatestCommonDivisor

//data class Tuple4<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)

val zero = 0.toLong()

/**
 * g = gcd(a, b) => (g | gcd(b, a mod b))  <Divides>
 */
tailrec fun gcd(a: Long, b: Long): Long =
        if (b == zero) a
        else gcd(b, a % b)

/**
 * Iterative algorithm
 */
fun gcd1(a: Long, b: Long): Long{
    var a1 = a
    var b1 = b
    while (b != zero){
        var temp = b1
        b1 = a1 % b1
        a1 = temp

    }
    return b1
}

/**
 * Least Common Multiple:
 * lcm(a, b) = (a * b) / gcd(a, b)
 */
fun lcm(a: Long, b: Long): Long = (a / gcd(a, b)) * b

/**
 * Calculate gcd(a, b) = ax + by for any integers x,y
 * Returns the triple : (gcd(a, b),x , y)
 */
fun gcdExtended(a: Long, b: Long): Triple<Long, Long, Long>{
    tailrec fun go(a: Long, b: Long, x: Long, y: Long, prevx: Long, prevy: Long): Triple<Long, Long, Long> =
            if (b == zero) Triple(a, prevx, prevy)
            else {
                val q = a/b
                go(b, a % b, prevx -  q*x, prevy - q*y, x, y)
            }
    return go(a, b, 0, 1, 1, 0)
}


fun gcdExtended1(a: Long, b: Long): Triple<Long, Long, Long>{
    var x: Long = 1
    var y: Long = 1
    var x1: Long
    var y1: Long
    fun go(a: Long, b: Long): Long{
        if (b == zero) {
            x = 1
            y = 0
            return a
        }
        else{
            val g = go(b, a % b)

            x1 = y
            y1= x - y*(a/b)
            x = x1
            y = y1

            return g
        }
    }
    return Triple(go(a, b), x, y)
}



fun main(args: Array<String>) {
    val g = gcdExtended(1398, 324)
    val g1 = gcdExtended1(1398, 324)
    val g2 = gcdExtended(4, 6)
    println("gcd(a, b) = ${g.first}, x = ${g.second}, y = ${g.third}")
    println("gcd(a, b) = ${g1.first}, x = ${g1.second}, y = ${g1.third}")
    println("gcd(a, b) = ${g2.first}, x = ${g2.second}, y = ${g2.third}")

}