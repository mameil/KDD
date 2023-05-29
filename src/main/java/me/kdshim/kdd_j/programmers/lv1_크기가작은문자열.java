package me.kdshim.kdd_j.programmers;

import java.util.ArrayList;

public class lv1_크기가작은문자열 {

    public int solution(String t, String p) {
        int answer = 0;
        int index = p.length();
        ArrayList<Integer> list = new ArrayList<>();
        long ip = Long.parseLong(p);

        for(int i=0; i<t.length()-index+1; i++){
//            list.add(Integer.parseInt(t.substring(i, i+index)));
            if(Long.parseLong(t.substring(i, i+index)) <= ip){
                answer++;
            }
        }

        //stream 이라서 통과안되는건가 억까인가 >> 진짜 스트림이라서 안된거네...
//        answer = list.stream().filter(num -> num <= ip).toArray().length;

        return answer;
    }
}
