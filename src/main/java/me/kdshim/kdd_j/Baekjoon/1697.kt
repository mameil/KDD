package me.kdshim.kdd_j.Baekjoon

import java.util.*
class `1697` {

    fun main(){
        val (start, end) = readLine()!!.split(" ").map{ it.toInt() }
        val max = 100000

        val visited = BooleanArray(max + 1)
        val dist = IntArray(max + 1)

        val q: Queue<Int> = LinkedList()
        q.add(start)
        visited[start] = true
        dist[start] = 0

        while(q.isNotEmpty()){
            val cur = q.poll()

            if(cur == end) {
                println(dist[cur])
                return
            }

            val nexts = intArrayOf(cur-1, cur+1, cur*2)

            for(next in nexts) {
                if(next in 0..max && !visited[next]){
                    visited[next] = true
                    q.add(next)
                    dist[next] = dist[cur] + 1
                }
            }
        }
    }
}