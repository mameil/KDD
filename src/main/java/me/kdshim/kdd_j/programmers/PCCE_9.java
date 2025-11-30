package me.kdshim.kdd_j.programmers;

public class PCCE_9 {
    class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            while(
                    (getSmallest(bill[0], bill[1]) > getSmallest(wallet[0], wallet[1]))
                            || (getBiggest(bill[0], bill[1]) > getBiggest(wallet[0], wallet[1]))
            ){
                if(bill[0] > bill[1]){
                    bill[0] = bill[0]/2;
                } else {
                    bill[1] = bill[1]/2;
                }
                answer++;
            }

            return answer;
        }

        public int getSmallest(int a, int b){
            if(a > b){
                return b;
            } else {
                return a;
            }
        }

        public int getBiggest(int a, int b){
            if(a > b){
                return a;
            } else {
                return b;
            }
        }
    }
}
