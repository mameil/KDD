package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class arrayList_1269 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> list = new HashSet<>(N);
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> list2 = new HashSet<>(M);
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int e = Integer.parseInt(st.nextToken());
            if(list.contains(e))
                set.add(e);
            list2.add(e);
        }

        int from = 0;
        int to = 0;

        for (Integer it : list) {
            if(!set.contains(it)){
                from++;
            }
        }

        for(Integer it : list2){
            if (!set.contains(it)) {
                to++;
            }
        }

        System.out.println(from + to);

    }


}
