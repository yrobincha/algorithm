package programmers.levelThree.Solutions20210902;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SolutionsTwo {

  public int[] solution(String[] genres, int[] plays) {
    HashMap<String, Integer> albums = new HashMap<>();
    Integer[] tmp = new Integer[genres.length];

    for (int i = 0; i < genres.length; i++) {
      albums.put(genres[i], albums.getOrDefault(genres[i], 0) + plays[i]);
      tmp[i] = i;
    }

    Arrays.sort(tmp, (o1, o2) -> {
      String s1 = genres[o1];
      String s2 = genres[o2];
      int result = albums.get(s2) - albums.get(s1);
      if (result == 0) {
        result = plays[o2] - plays[o1];
      }
      return result;
    });

    ArrayList<Integer> list = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    for (int i : tmp) {
      String key = genres[i];
      int count = map.getOrDefault(key, 0);
      if (count < 2) {
        list.add(i);
        map.put(key, count + 1);
      }
    }
    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }
}