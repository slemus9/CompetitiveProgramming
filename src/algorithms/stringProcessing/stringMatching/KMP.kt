package algorithms.stringProcessing.stringMatching

object KMP {

    fun getLps (s: String): Array<Int>{
        val n = s.length
        val lps = Array(n){0}
        var j = 0
        var i = 1

        while (i < n){
            if (s[i] == s[j]){
                lps[i] = j + 1
                i++
                j++
            } else{
                if (j == 0){
                    lps[i] = 0
                    i++
                } else{
                    j = lps[j - 1]
                }
            }
        }
        return lps
    }

    fun kmpSearch (pattern: String, s: String): List<Int> {
        val indices = ArrayList<Int>()
        val n = s.length
        val m = pattern.length
        var i = 0
        var j = 0
        val lps = getLps(s)

        while (i < n){
            if (j == m){
                indices.add(i - m)
                j = 0
            } else if (s[i] == pattern[j]){
                i++
                j++
            } else{
                if (j == 0){
                    i++
                } else{
                    j = lps[j - 1]
                }
            }
        }

        if (j == m) indices.add(i - m)
        return indices
    }
}

fun main() {
    println(KMP.kmpSearch("sebastian", "asdafrwgfasdaDAFEsebastiansadsadadwqw"))
}