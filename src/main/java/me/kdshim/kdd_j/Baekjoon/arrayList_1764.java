package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class arrayList_1764 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String key = br.readLine();
            map.put(key, key);
        }

        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<M; i++){
            String key = br.readLine();
            if(map.containsKey(key)){
                list.add(map.get(key));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        list.stream().sorted().forEach(it -> sb.append(it).append("\n"));

        System.out.println(sb);
    }


}
