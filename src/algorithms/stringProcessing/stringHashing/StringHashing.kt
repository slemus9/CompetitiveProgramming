package algorithms.stringProcessing.stringHashing

import algorithms.algebra.fundamentals.binExpRec
import algorithms.algebra.modularArithmetic.modularInverse.modInverse

// Calculation of the hash of a string

/**
 * h(s) = \sum_{i=0}^{n-1} s_i*p^i mod m
 * Recommended: p = 31, m = 10^9 + 9
 */
fun computeHash(s: String, p: Int, m: Int): Long{
    var hashVal = 0L
    var p_pow = 1L
    for (c in s){
        hashVal = (hashVal + (c - 'a' + 1)*p_pow) % m
        p_pow = (p * p_pow) % m
    }
    return hashVal
}

fun computeHash1(s: String, p: Int, m: Int): Long{

    tailrec fun go(s: String, p_pow: Long, hashVal: Long): Long =
        if (s.isEmpty())
            hashVal
        else
            go(s.drop(1), (p * p_pow) % m, (hashVal + (s.first() - 'a' + 1)*p_pow) % m)

    return go(s, 1, 0)
}

/**
 * Search for duplicate strings in an array (of size n) of strings (each no longer than m)
 * Complexity: O(nm + n log n)
 */
fun groupIdenticaStrings(ss : List<String>): ArrayList<ArrayList<Int>>{
    val p = 31
    val m = 1000000000 + 9
    val n = ss.size
    val hashes = ArrayList<Pair<Long, Int>>()

    for (i in 0 until n)
        hashes[i] = Pair(computeHash(ss[i], p, m), i)

    val sortedHashes = hashes.sortedBy { it.first }

    val groups = ArrayList<ArrayList<Int>>()
    val firstGroup = ArrayList<Int>()
    firstGroup.add(0)
    groups.add(firstGroup)
    var groupId = 0
    var i = 1

    while (i < n){
        if (sortedHashes[i].first == sortedHashes[i - 1].first)
            groups[groupId].add(i)
        else{
            val newGroup = ArrayList<Int>()
            newGroup.add(i)
            groups.add(newGroup)
            groupId ++
        }
        i ++
    }

    return groups
}

/**
 * Calculates an array hs such that hs[ i ] = H(s[0 .. i])
 */
fun precHash(s: String, p: Int, m: Int): Array<Long>{
    val hs = Array<Long>(s.length){x -> 0}
    var curr = ""

    for (i in 0 until s.length){
        curr += s[i]
        hs[i] = computeHash(curr, p, m)
    }

    return hs
}

/**
 * Mod function that avoids negative modulo results
 */
fun mod(x: Long, m: Long) = (x % m + m) % m

/**
 * Find the hash of a substring s[i ... j]. Recall:
 * H(s[i ... j]*p^i = (H(s[0 ... j]) - H(s[0 ... i-1]) mod m
 */
fun fastSubstringHash(s: String, i: Int, j: Int): Long{

    // Examples of p and m if the alphabet has 26 letters
    val p = 31
    val m = 1000000000 + 9
    val hs = precHash(s, p, m)
    val pow = binExpRec(pL, iL)
    val inv = modInverse(pow, mL)

    return inv*mod(hs[j] - hs[if (i == 0) 0 else i - 1], mL)
}