package me.kdshim.kdd_j.Baekjoon

class `11724` {
    fun main(){
        val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
        val map = Array(n+1) { mutableListOf<Int>() }

        repeat(m){
            val (a, b) = readLine()!!.split(" ").map{ it.toInt() }
            map[a].add(b)
            map[b].add(a)
        }

        val visited = BooleanArray(n+1) { false }

        fun fn(node: Int){
            visited[node] = true
            for(next in map[node]){
                if(!visited[next]){
                    fn(next)
                }
            }
        }

        var count = 0

        for (i in 1..n){
            if(!visited[i]){
                fn(i)
                count++
            }
        }

        println(count)
    }
}