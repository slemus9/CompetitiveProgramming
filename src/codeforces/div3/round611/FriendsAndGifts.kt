package codeforces.div3.round611

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    v1()
}

fun v1(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val f = br.readLine().split(" ").map { it.toInt() - 1 }.toTypedArray()
    val receivedFrom = Array(n){-1}

    for (i in 0 until n){
        if (f[i] != -1){
            receivedFrom[f[i]] = i
        }
    }

    val alone = mutableListOf<Int>()
    for (i in 0 until n){
        if (f[i] == -1 && receivedFrom[i] == -1){
            alone += i
        }
    }

    if (alone.size == 1){
        val e = alone.first()
        for (i in 0 until n){
            if (i != e){
                if (f[i] == -1){
                    f[i] = e
                    receivedFrom[e] = i
                    break
                }
            }
        }
    }else{
        for (i in alone.indices){
            val currAlone = alone[i]
            val nextAlone = alone[(i + 1) % alone.size]
            f[currAlone] = nextAlone
            receivedFrom[nextAlone] = currAlone
        }
    }


    val missingToGive = mutableListOf<Int>()
    val missingToReceive = mutableListOf<Int>()
    for (i in 0 until n){
        if (f[i] == -1){
            missingToGive += i
        }
        if (receivedFrom[i] == -1){
            missingToReceive += i
        }
    }

    for (i in 0 until missingToGive.size){
        f[missingToGive[i]] = missingToReceive[i]
    }

    println(f.map { it + 1 }.joinToString(" "))
}

fun v2(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val f = br.readLine().split(" ").map { it.toInt() - 1}.toMutableList()

    val heads = joinSequences(f)

    val tails = heads.values.toSet()
    var alone = mutableListOf<Int>()
    f.forEachIndexed { index, i ->
        if(i == -1 && !tails.contains(index)){
            alone.add(index)
        }
    }

    if(alone.size == 1){
        val key = heads.keys.toList().first()
        val newTail = alone.first()
        val oldTail = heads[key]!!
        f[oldTail] = newTail
        heads[key] = newTail
    } else {
        for(i in alone.indices){
            f[alone[i]] = alone[(i + 1) % alone.size]
        }
    }

    for((from, to) in heads){
        if(f[to] == -1){
            f[to] = from
        }
    }

    println(f.map { it + 1 }.joinToString(" "))

}

data class Mark(val dest: Int, var mark: Boolean)
fun joinSequences(f: MutableList<Int>): MutableMap<Int, Int>{
    val heads = mutableMapOf<Int, Int>()
    val marks = f.map { Mark(it, false) }
    for(i in marks.indices) {
        if(!marks[i].mark && marks[i].dest != -1){
            marks[i].mark = true
            var j = marks[i].dest
            if(marks[j].mark) {
                val oldSeq = heads[j]!!
                heads.remove(j)
                heads[i] = oldSeq
            } else {
                while(marks[j].dest != -1 && !marks[j].mark){
                    marks[j].mark = true
                    j = marks[j].dest
                }
                heads[i] = j
            }
        }
    }
    return heads
}