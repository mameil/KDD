package me.kdshim.kdd_j.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lv2_모음사전 {
    public static void main(String[] args) {

    }

    public int solution(String word) {

        String aeiou = "AEIOU";
        List list = new ArrayList<>();
        for(int i=1; i<=5; i++){
            recurse(aeiou, "", i, list);
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                return (i+1);
            }
        }
        return 0;
    }

    public void recurse(String str, String prefix, int length, List<String> list){
        if(prefix.length() == length){
            list.add(prefix);
        } else {
            for(int i=0; i<str.length(); i++){
                recurse(str, prefix + str.charAt(i), length, list);
            }
        }
    }
}
