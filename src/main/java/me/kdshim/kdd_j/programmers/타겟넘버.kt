package me.kdshim.kdd_j.programmers

class 타겟넘버 {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        fun fn(iv: Int, index: Int) {
            if(index == numbers.size){
                if(iv == target){
                    answer++
                }
                return
            }

            val nexts = listOf(iv+numbers[index], iv-numbers[index])

            fn(nexts[0], index+1)
            fn(nexts[1], index+1)
        }

        fn(0, 0)

        return answer
    }
}