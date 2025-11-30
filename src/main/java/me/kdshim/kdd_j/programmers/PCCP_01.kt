package me.kdshim.kdd_j.programmers

class PCCP_01 {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        var answer: String = ""

        var current = pos

        for(i in commands){
            if(parseTime(current) in parseTime(op_start)..parseTime(op_end)){
                current = op_end
            }

            current = if(i == "prev"){
                calculateTime(current, -10)
            } else {
                calculateTime(current, 10)
            }

            if(Integer.valueOf(parseTime(current)) < 0){
                current = "00:00"
            }

            else if(parseTime(current) >= parseTime(video_len)){
                current = video_len
            }

            if(parseTime(current) in parseTime(op_start)..parseTime(op_end)){
                current = op_end
            }
        }

        answer = current

        return answer
    }

    fun calculateTime(baseTime: String, plusSecond: Int): String{
        var parsedTime = baseTime.split(":")
        var mm = Integer.valueOf(parsedTime.get(0))
        var ss = Integer.valueOf(parsedTime.get(1))

        var totalSecond = mm*60 + ss
        var resultSecond = totalSecond + plusSecond

        return "${String.format("%02d", resultSecond / 60)}:${String.format("%02d", resultSecond % 60)}"
    }

    fun parseTime(baseTime: String): Int {
        var parsedTime = baseTime.split(":")
        var mm = Integer.valueOf(parsedTime.get(0))
        var ss = Integer.valueOf(parsedTime.get(1))
        return mm*100 + ss
    }
}

data class TestCase(
    val videoLen: String,
    val pos: String,
    val opStart: String,
    val opEnd: String,
    val commands: Array<String>,
    val expected: String
)

fun main() {
    val s = PCCP_01()

    val tests = listOf(
//        TestCase("34:33", "13:00", "00:55", "02:55", arrayOf("next", "prev"), "13:00"),
        TestCase("10:55", "00:05", "00:15", "06:55", arrayOf("prev", "next", "next"), "06:55"),
//        TestCase("07:22", "04:05", "00:15", "04:07", arrayOf("next"), "04:17")
    )

    for ((index, tc) in tests.withIndex()) {
        val result = s.solution(tc.videoLen, tc.pos, tc.opStart, tc.opEnd, tc.commands)
        println("Test ${index + 1}:")
        println("  video_len=${tc.videoLen}, pos=${tc.pos}, op_start=${tc.opStart}, op_end=${tc.opEnd}, commands=${tc.commands.joinToString()}")
        println("  result = $result, expected = ${tc.expected}")
        println("  ${if (result == tc.expected) "PASS ✅" else "FAIL ❌"}")
        println()
    }
}
