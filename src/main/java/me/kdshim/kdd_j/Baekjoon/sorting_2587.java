package me.kdshim.kdd_j.Baekjoon;

import java.io.*;
import java.util.*;

public class sorting_2587 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for(int i=0; i<5; i++){
            int recv = Integer.parseInt(br.readLine());
            sum+=recv;
            arr[i] = recv;
        }

        System.out.println(sum/5);

        Arrays.sort(arr);
        System.out.println(arr[2]);

    }
}
