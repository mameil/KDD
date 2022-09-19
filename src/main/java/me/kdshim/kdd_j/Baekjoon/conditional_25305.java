package me.kdshim.kdd_j.Baekjoon;

import java.util.*;
import java.io.*;

public class conditional_25305{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCnt = Integer.parseInt(st.nextToken());
        int winnerCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<totalCnt; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Integer::compareTo);
        System.out.println(list.get(totalCnt - winnerCnt));
    }

    public static void main2(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCnt = Integer.parseInt(st.nextToken());
        int winnerCnt = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[totalCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(arr[winnerCnt-1]);
    }
}
