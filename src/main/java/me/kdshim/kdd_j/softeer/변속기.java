package me.kdshim.kdd_j.softeer;


import java.io.*;
import java.util.*;

public class 변속기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for(int i=0; i<8; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] desc = {8, 7, 6, 5, 4, 3, 2, 1};
        if(Arrays.equals(arr, asc))
            System.out.println("ascending");
        else if(Arrays.equals(arr, desc))
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
