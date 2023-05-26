package me.kdshim.kdd_j.Baekjoon;

import java.io.*;
import java.util.*;

public class arr_map_7785{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i=0 ;i<cnt; i++){
            String[] arr = br.readLine().split(" ");
            map.put(arr[0], arr[1]);
        }

        for (String s : map.keySet()) {
            if(map.get(s).equals("enter"))
                list.add(s);
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}