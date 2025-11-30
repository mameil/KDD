package me.kdshim.kdd_j.Baekjoon

class `2667_2` {

    fun main(){
        val n = readLine()!!.toInt()
        val map = Array(n) { readLine()!!.map{ it - '0'}.toIntArray() }
        val visited = Array(n) { BooleanArray(n) }

        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)

        fun fn(x: Int, y: Int): Int {
            var count = 1
            for(i in 0 until 4){
                var nx = x + dx[i]
                var ny = y + dy[i]
                if(nx in 0 until n && ny in 0 until n && !visited[nx][ny] && map[nx][ny] == 1){
                    count += fn(nx, ny)
                }
            }

            return count
        }

        val resultList = mutableListOf<Int>()

        for (i in 0 until n){
            for (j in 0 until n){
                if(!visited[i][j]){
                    resultList.add(fn(i, j))
                }
            }
        }

        println(resultList.size)
        resultList.sorted().forEach{ println(it) }
    }
}