package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class arrayList_11478 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for(int j=0; j<str.length(); j++){
                while(j + i < str.length()){
                    String found = str.substring(j, j+i+1);
                    if(!set.contains(found))
                        set.add(found);
                    j++;
                }
            }
        }

        System.out.println(set.size());
    }
}
