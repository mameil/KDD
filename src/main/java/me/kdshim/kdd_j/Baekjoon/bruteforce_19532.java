package me.kdshim.kdd_j.Baekjoon;

import java.io.*;

public class bruteforce_19532 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int x = -999;
        int y = -999;

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);

        int d = Integer.parseInt(arr[3]);
        int e = Integer.parseInt(arr[4]);
        int f = Integer.parseInt(arr[5]);

        for(int i=-999; i<1000; i++){
            for(int j=-999; j<1000; j++){
                if(
                        a*i + b*j == c
                        && d*i + e*j == f
                ){
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
