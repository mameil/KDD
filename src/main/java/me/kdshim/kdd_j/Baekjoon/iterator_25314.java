package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class iterator_25314 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine())/4;
        String str = "";
        for (int i = 0; i < cnt; i++) {
            str = "long " + str;
        }

        System.out.println(str+"int");
    }
}
