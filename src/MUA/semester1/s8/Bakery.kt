package MUA.semester1.s1.s8

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val nmk = br.readLine().split(" ").map { it.toInt() }
    val n = nmk[0]
    val m = nmk[1]
    val k = nmk[2]
    val graph = HashMap<Int, HashMap<Int, Long>>()
    val factories = HashSet<Int>()

    if(k > 0){

        for (i in 1 .. m){
            val uvl = br.readLine().split(" ").map { it.toLong() }
            val u = uvl[0].toInt()
            val v = uvl[1].toInt()
            val l = uvl[2]

            if (!graph.containsKey(u)){
                graph.put(u, HashMap())
            }
            var preVal = graph.get(u)?.get(v)
            if (preVal == null || preVal > l){
                graph.get(u)?.put(v, l)
            }


            if (!graph.containsKey(v)){
                graph.put(v, HashMap())
            }
            preVal = graph.get(v)?.get(u)
            if (preVal == null || preVal > l){
                graph.get(v)?.put(u, l)
            }
        }

        br.readLine().split(" ").forEach { factories.add(it.toInt()) }

        var min = Long.MAX_VALUE

        for ((city, destinations) in graph){
            if(factories.contains(city)){
                for ((d, w) in destinations){
                    if(!factories.contains(d)){
                        min = if (min < w) min else w
                    }
                }
            }
        }

        min = if (min == Long.MAX_VALUE) -1 else min
        println(min)

    }else{
        println(-1)
    }

}