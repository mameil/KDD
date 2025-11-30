package me.kdshim.kdd_j.programmers;

import java.util.*;

public class PCCE_10 {
    class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            int[][] answer = {};

            Map<String, Integer> parse = Map.of(
                    "code", 0,
                    "date", 1,
                    "maximum", 2,
                    "remain", 3
            );

            List<int[]> ansList = new ArrayList<int[]>();

            for(int i=0; i<data.length; i++){
                if(data[i][parse.get(ext)] == val_ext){
                    ansList.add(data[i]);
                }
            }

            ansList.sort(Comparator.comparing(row -> row[parse.get(sort_by)]));

            answer = (int[][]) ansList.toArray();


            List<String> temp = Arrays.asList("code", "date", "maximum", "remain");

            Arrays.stream(data)
                    .filter(ints ->  ints[temp.indexOf(sort_by)] == val_ext)
                    .sorted(Comparator.comparing(row -> row[temp.indexOf(sort_by)]));

            return answer;
        }
    }
}
