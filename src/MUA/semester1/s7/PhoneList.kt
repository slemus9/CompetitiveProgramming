package MUA.semester1.s1.s7

import java.io.BufferedReader
import java.io.InputStreamReader

object PhoneList{

    fun addConsistentPhone(trieList: MutableList<Trie?>, numList: List<Int>) : Boolean{

        var currentList = trieList

        for (i in 0 until  numList.size){
            val digit = numList[i]
            val trie = currentList[digit]
            if (trie == null){
                val newTrie = Trie(digit, i == numList.size - 1, createEmptyChildrenList())
                currentList[digit] = newTrie
                currentList = newTrie.children
            }else{
                if (trie.terminal || i == numList.size - 1){
                    return false
                }
                currentList = trie.children
            }

        }
        return true
    }

    fun createEmptyChildrenList(): MutableList<Trie?>{
        val list = mutableListOf<Trie?>()
        for (i in 1..10){
            list.add(null)
        }
        return list

    }
}

data class Trie(
        val value: Int,
        var terminal : Boolean,
        var children : MutableList<Trie?>)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 0 until t){
        val n = br.readLine().toInt()
        val trieList = PhoneList.createEmptyChildrenList()
        var allConsistent = true

        for (i in 0 until n){
            val num = br.readLine()
            if (allConsistent) {
                allConsistent = PhoneList.addConsistentPhone(trieList,
                        num.trim().toCharArray().map { it.toString().toInt()})
            }
        }
        println(if (allConsistent) "YES" else "NO")
    }

}