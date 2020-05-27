package codeforces.div3.round644

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

object BuyingShovels {
    fun primesUpTo (n: Int): List<Int> {
        val primes = mutableListOf(2, 3)
        for (i in 5 .. n step 2) {
            var isPrime = true
            for (p in primes) {
                if (i % p == 0) {
                    isPrime = false
                    break
                }
            }
            if (isPrime) {
                primes.add(i)
            }
        }
        return primes
    }

    fun primeDecomposition (primes: List<Int>, n: Int): List<Pair<Int, Int>> {
        val decomposition = mutableListOf<Int>()

        for (p in primes) {
            if (n % p == 0) {
                decomposition.add(p)
            }
        }

        var curr = n
        val exps = mutableListOf<Int>()
        for (p in decomposition) {
            var exp = 0
            while (curr % p == 0) {
                curr /= p
                exp += 1
            }
            exps.add(exp)
        }
        if (curr > 1) {
            decomposition.add(curr)
            exps.add(1)
        }

        return decomposition zip exps
    }

    fun solution (primeDecomposition: MutableList<Pair<Int, Int>>, limit: Int): Int {
        fun go (primeDecomposition: MutableList<Pair<Int, Int>>, current: Int): Int {
            if (primeDecomposition.isEmpty()) {
                return current
            } else {
                val right =
                    if (primeDecomposition.size == 1) current
                    else go(primeDecomposition.drop(1).toMutableList(), current)
                val (x, y) = primeDecomposition[0]
                val left =
                    if (y == 0 || x*current > limit) current
                    else {
                        primeDecomposition[0] = x to y - 1
                        go(primeDecomposition, current*x)
                    }
                return max(right, left)
            }
        }
        return go(primeDecomposition, 1)
    }

    fun main() {
        val primes = primesUpTo(31630)
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().toInt()
        for (i in 1 .. t) {
            val (n, k) = br.readLine().split(" ").map { it.toInt() }
            val primeDec = primeDecomposition(primes, n)
            println(n/solution(primeDec as MutableList<Pair<Int, Int>>, k))
        }
    }
}

fun main() {
    BuyingShovels.main()
}
