package algorithms.algebra.modularArithmetic.modularInverse

import algorithms.algebra.fundamentals.greatestCommonDivisor.gcdExtended

const val zero = 0L


/**
 * Calculate modular inverse of a. Recall:
 * a*x = 1 (mod m ) == a*x mod m = 1
 * Solve for x and y the Diophantine Equation: a*x + m*y = 1
 *
 * The modular inverse exists only if gcd(a,m) = 1 (a and m
 * are co-primes)
 */
fun modInverse(a: Long, m: Long): Long {
    val gcd = gcdExtended(a, m)
    val g = gcd.first
    val x = gcd.second
    if (g != 1L) return -1
    else return (x % m + m) % m
}

fun main() {
    println(modInverse(3, 11))
    println(modInverse(10, 17))
    println(modInverse(31, (1e9 + 9).toLong()))
}