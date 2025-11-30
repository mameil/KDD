package me.kdshim.kdd_j.Baekjoon

class `2606` {
    fun main(){
        val computerCount = readLine()!!.toInt()
        val pairCount = readLine()!!.toInt()

        var map = Array(computerCount+1) { mutableListOf<Int>() }
        var visited = BooleanArray(computerCount+1)

        var cnt = 0

        fun fn(index: Int){
            visited[index] = true
            for(next in map[index]){
                if(!visited[next]){
                    cnt++
                    fn(next)
                }
            }
        }

        repeat(pairCount){
            val (a, b) = readLine()!!.split(" ").map{ it.toInt() }
            map[a].add(b)
            map[b].add(a)
        }

        fn(1)
        println(cnt)
    }
}