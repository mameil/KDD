package me.kdshim.kdd_j.programmers;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

class lv1_run {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> play = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(i, players[i]);
            play.put(players[i], i);
        }

        for(int j=0; j<callings.length; j++){
            String playerName = callings[j];
            int num = play.get(playerName);

            int num2 = num-1;
            String playerName2 = map.get(num2);

            map.put(num, playerName2);
            play.put(playerName, num2);
            map.put(num2, playerName);
            play.put(playerName2, num);

        }

        answer = new String[players.length];
        for(int i=0; i< players.length; i++){
            answer[i] = map.get(i);
        }
        return answer;
    }
}
