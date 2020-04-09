package codeforces.exercises

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    SantaClausAndPalindrome.main()
}

object SantaClausAndPalindrome {

    val p = 31L
    val m = (1e9 + 9).toLong()
    var pows = mutableListOf<Long>()
    var prefixes = mutableListOf<Pair<Long, Int>>()
    var hashReverse = HashMap<Long, Long>()
    val a = mutableListOf<Int>()

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (k, n) = br.readLine().split(" ").map { it.toInt() }
        pows = computePowers(n)
        for (i in 0 until k){
            val (s_i, a_i) = br.readLine().split(" ")
            a.add(a_i.toInt())
            val prefixHash = computeHash(s_i)

            prefixes.add(prefixHash to i)
            hashReverse[prefixHash] = computeHash(s_i.reversed())
        }

        val prefixGroup = prefixes.groupBy { it.first }
        val palindromes = prefixes.filter { (x, _) ->  hashReverse[x] == x}

        println(prefixGroup)
        println(hashReverse)
        println(palindromes)
        println(a)
    }

    fun computeHash (s: String): Long{
        val n = s.length
        var prev = s[0] - 'a' + 1L
        var hash = 0L
        for (i in 0 until n){
            hash = (prev + (s[i] - 'a' + 1) * pows[i]) % m
        }
        return hash
    }

    fun computePowers (n: Int): MutableList<Long>{
        val pows = MutableList(n){0L}
        pows[0] = 1
        for (i in 1 until n){
            pows[i] = (p*pows[i - 1]) % m
        }
        return pows
    }
}