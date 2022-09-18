package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class conditional_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        int compare = 0;
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            compare += (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
        }
        String str = total == compare ? "Yes" : "No";
        System.out.println(str);
    }
}
