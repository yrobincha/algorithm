package programmers.levelTwo.Solutions20210825;

import java.util.ArrayList;
import java.util.HashMap;

public class SolutionsOne {

  public int solution(int cacheSize, String[] cities) {
    if (cacheSize == 0) {
      return cities.length * 5;
    }
    int answer = 0;
    HashMap<String, Integer> cityMap = new HashMap<>();
    ArrayList<String> queue = new ArrayList<>();

    for (String city : cities) {
      city = city.toLowerCase();
      if (queue.size() < cacheSize) {
        if (queue.contains(city)) {
          answer += 1;
          queue.remove(city);
        } else {
          answer += 5;
        }
      } else {
        if (queue.contains(city)) {
          answer += 1;
          queue.remove(city);
        } else {
          answer += 5;
          String last = queue.get(queue.size() - 1);
          cityMap.put(last, cityMap.getOrDefault(last, 0) - 1);
          queue.remove(queue.size() - 1);
        }
      }
      queue.add(0, city);
      cityMap.put(city, cityMap.getOrDefault(city, 0) + 1);
    }
    return answer;
  }
}