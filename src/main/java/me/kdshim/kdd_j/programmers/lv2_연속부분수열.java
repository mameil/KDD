package me.kdshim.kdd_j.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class lv2_연속부분수열 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 1, 1, 4}));
    }

    public static int solution(int[] elements){
        Set<Integer> memozation = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = 0; j < elements.length; j++) {
                /*
                7,7 (0,0) > 0
                7,9 (0,1) > 1
                7,1 (0,2) > 2
                7,1 (0,3) > 3
                7,4 (0,4) > 4
                9,7 (1,0) > 1
                9,9 (1,1) > 2
                 */
                sum += elements[(i+j)%elements.length];
                memozation.add(sum);
            }
        }

        return memozation.size();
    }


}
