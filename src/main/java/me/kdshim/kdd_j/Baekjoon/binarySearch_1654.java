package me.kdshim.kdd_j.Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class binarySearch_1654 {

    public static void Main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0;  i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


    }
}
