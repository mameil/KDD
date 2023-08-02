package me.kdshim.kdd_j.softeer;

import java.util.*;
import java.io.*;


public class 근무시간
{
    public static void main(String args[]) throws Exception
    {
        System.out.println("이제 입력하세요");
        Scanner br = new Scanner(System.in);
        String[] days = new String[5];
        for(int i=0; i<5; i++){
            days[i] = br.nextLine();
        }

        int totalHH = 0;
        int totalMM = 0;

        for(int i=0; i<5; i++){
            String[] arr = days[i].split(" ");
            String fromHHMM = arr[0];
            String toHHMM = arr[1];

            int fromHH = Integer.parseInt(fromHHMM.split(":")[0]);
            int toHH = Integer.parseInt(toHHMM.split(":")[0]);
            int diffHH = toHH - fromHH;

            int fromMM = Integer.parseInt(fromHHMM.split(":")[1]);
            int toMM = Integer.parseInt(toHHMM.split(":")[1]);
            int diffMM = 0;
            if(toMM - fromMM < 0){
                diffHH = diffHH-1;
                diffMM = (60-fromMM) + toMM;
            }else{
                diffMM += toMM - fromMM;
            }

            totalHH += diffHH;
            totalMM += diffMM;
        }

        System.out.println(totalHH*60 + totalMM);
    }
}