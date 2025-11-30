package me.kdshim.kdd_j.Baekjoon

class `2606_2` {
    fun main(){
        val n = readLine()!!.toInt()
        val m = readLine()!!.toInt()
        val map = Array(n+1) { mutableListOf<Int>() }
        val visited = BooleanArray(n+1) { false }

        repeat(m) {
            val (a, b) = readLine()!!.split(" ").map{ it.toInt() }
            map[a].add(b)
            map[b].add(a)
        }

        var count = 0

        fun fn(index: Int) {
            visited[index] = true
            for(next in map[index]){
                if(!visited[next]){
                    count++
                    fn(next)
                }
            }
        }

        fn(1)
        println(count)
    }
}