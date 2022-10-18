package me.kdshim.kdd_j.Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class arrayList_10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mainCnt = Integer.parseInt(br.readLine());
        int[] mainArr = new int[mainCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mainCnt; i++) {
            mainArr[i] = Integer.parseInt(st.nextToken());
        }

        int comCnt = Integer.parseInt(br.readLine());
        int[] comArr = new int[comCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < comCnt; i++) {
            comArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[comCnt];

        Arrays.sort(mainArr);

        for(int i=0; i<comArr.length; i++){
            result[i] = Arrays.binarySearch(mainArr, comArr[i]) >= 0 ? 1 : 0;
        }

        for (int i = 0; i < comCnt; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int binarySearch(int[] arr, int index) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (end - start >= 0) {
            mid = (end + start) / 2;

            if (arr[mid] == index) {
                return 1;
            } else if (arr[mid] < index) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}
