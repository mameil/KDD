package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class arrayList_14425 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> target = new HashMap<>();

        for(int i=0; i<n; i++){
            target.put(br.readLine(), i);
        }

        int result = 0;

        for(int i=0; i<m; i++){
            if(target.containsKey(br.readLine()))
                result++;
        }

        System.out.println(result);
    }
}
