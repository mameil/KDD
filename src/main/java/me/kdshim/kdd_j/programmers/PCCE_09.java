package me.kdshim.kdd_j.programmers;

public class PCCE_09 {
    class Solution {
        public int solution(String[][] board, int h, int w) {
            int answer = 0;

            if((w>=0 && w<board[h].length) && h+1 < board.length && board[h+1][w].equals(board[h][w])){
                answer++;
            }

            if((w>=0 && w<board[h].length) && h-1 >= 0 && board[h-1][w].equals(board[h][w])){
                answer++;
            }

            if((h>=0 && h<board[h].length) && w+1 < board[h].length && board[h][w+1].equals(board[h][w])){
                answer++;
            }

            if((h>=0 && h<board[h].length) && w-1 >= 0 && board[h][w-1].equals(board[h][w])){
                answer++;
            }

            return answer;
        }
    }
}
