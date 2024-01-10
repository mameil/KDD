package me.kdshim.kdd_j.programmers.hash;

import java.util.*;

public class lv3_베스트앨범 {
    public static void main(String[] args) {
        lv3_베스트앨범 lv3_베스트앨범 = new lv3_베스트앨범();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println("==============================================");
        Arrays.stream(lv3_베스트앨범.solution(genres, plays)).forEach(System.out::println);
        System.out.println("==============================================");
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<Integer, HashMap<String, Integer>> music = new HashMap<>();
        HashMap<String, Integer> genreCount = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            HashMap<String, Integer> temp = new HashMap<>();
            temp.put(genres[i], plays[i]);
            music.put(i, temp);
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genreList = new ArrayList<>(genreCount.keySet());
        genreList.sort((o1, o2) -> genreCount.get(o2).compareTo(genreCount.get(o1)));

        ArrayList<Integer> result = new ArrayList<>();
        for (String genre : genreList) {
            HashMap<Integer, Integer> topSongs = new HashMap<>();
            for (Map.Entry<Integer, HashMap<String, Integer>> entry : music.entrySet()) {
                if (entry.getValue().containsKey(genre)) {
                    topSongs.put(entry.getKey(), entry.getValue().get(genre));
                }
            }
            List<Integer> songList = new ArrayList<>(topSongs.keySet());
            songList.sort((o1, o2) -> topSongs.get(o2).compareTo(topSongs.get(o1)));

            for (int i = 0; i < Math.min(2, songList.size()); i++) {
                result.add(songList.get(i));
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }


}
