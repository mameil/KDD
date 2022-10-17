package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class arrayList_10815 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mainCnt = Integer.parseInt(br.readLine());
        HashSet<Integer> mainSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<mainCnt; i++){
            mainSet.add(Integer.parseInt(st.nextToken()));
        }

        int comCnt = Integer.parseInt(br.readLine());
        int[] comArr = new int[comCnt];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<comCnt; i++){
            comArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[comCnt];
        for(int i=0; i<comCnt; i++){
            result[i] = mainSet.contains(comArr[i]) ? 1 : 0;
        }

        for(int i=0; i<comCnt; i++){
            System.out.print(result[i] + " ");
        }
    }
}
