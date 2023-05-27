package me.kdshim.kdd_j.programmers;

import java.util.HashMap;
import java.util.Map;

public class lv1_추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++){
            int cnt = 0;
            for(int j=0; j<photo[i].length; j++){
                if(map.get(photo[i][j]) != null){
                    cnt+=map.get(photo[i][j]);
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
