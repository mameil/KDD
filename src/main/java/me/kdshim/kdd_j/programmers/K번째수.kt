package me.kdshim.kdd_j.programmers

class K번째수 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        commands.forEach {
            var popList = mutableListOf<Int>()
            for (i in it[0]-1 until it[1]){
                popList.add(array[i])
            }

            answer.add(popList.sorted()[it[2]-1])
        }

        return answer.toIntArray()
    }
}