// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;

class Solution {
    class Song {
        int index;
        int playCount;

        Song(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, List<Song>> genreSongMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreTotalMap.put(genres[i], genreTotalMap.getOrDefault(genres[i], 0) + plays[i]);

            genreSongMap.computeIfAbsent(genres[i], k -> new ArrayList<>());
            genreSongMap.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<String> genreOrder = new ArrayList<>(genreTotalMap.keySet());
        genreOrder.sort((a, b) -> genreTotalMap.get(b) - genreTotalMap.get(a));

        List<Integer> result = new ArrayList<>();

        for (String genre : genreOrder) {
            List<Song> songs = genreSongMap.get(genre);
            songs.sort((a, b) -> {
                if (b.playCount == a.playCount)
                    return a.index - b.index;
                return b.playCount - a.playCount;
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                System.out.println(result);
                result.add(songs.get(i).index);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
