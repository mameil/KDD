package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarySearch_1920 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];
        for(int i=0; i<M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[M];
        for(int i=0; i<M; i++){
            result[i] = search(arr1, arr2[i]);
        }


        for(int i=0; i<M; i++){
            System.out.println(result[i]);
        }
    }

    public static int search(int[] arr, int index){
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(end - start >= 0){
            mid = (start + end)/2;

            if(arr[mid] == index){
                return 1;
            }else if(arr[mid] < index){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
