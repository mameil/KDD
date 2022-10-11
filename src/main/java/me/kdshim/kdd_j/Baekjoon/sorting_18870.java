package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class sorting_18870 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int arr[] = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sorted[] = arr.clone();
        //이건 시간복잡도가 시간복잡도가 nlogn
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for(int i=0; i<cnt; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt; i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
