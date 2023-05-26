package me.kdshim.kdd_j.Baekjoon;

import java.io.*;
import java.util.*;

public class recursion_27433 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Long result = 1L;
        for(int i=1; i<=n; i++){
            result *= i;
        }

        System.out.println(result);
    }
}
