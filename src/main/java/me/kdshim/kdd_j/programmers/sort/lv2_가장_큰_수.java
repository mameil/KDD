package me.kdshim.kdd_j.programmers.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class lv2_가장_큰_수 {
    public static void main(String[] args) {
        lv2_가장_큰_수 lv2_가장_큰_수 = new lv2_가장_큰_수();
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        System.out.println(lv2_가장_큰_수.solution(numbers2));
    }

    public String solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        permute(numbers, 0, result);
        result.sort(Comparator.reverseOrder());

        return result.get(0).toString();
    }

    private void permute(int[] array, int index, List<Integer> result) {
        if (index == array.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int num : array) {
                sb.append(num);
            }
            result.add(Integer.parseInt(sb.toString()));
        } else {
            for (int i = index; i < array.length; i++) {
                swap(array, i, index);
                permute(array, index + 1, result);
                swap(array, i, index); // backtrack
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
