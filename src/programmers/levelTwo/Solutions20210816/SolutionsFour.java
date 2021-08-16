package programmers.levelTwo.Solutions20210816;

import java.util.HashMap;

public class SolutionsFour {

  public int solution(String[][] clothes) {
    HashMap<String, Integer> clothMap = new HashMap<>();
    for (String[] cloth : clothes) {
      clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
    }
    int answer = 1;
    for (int n : clothMap.values()) {
      answer *= (n + 1);
    }
    return answer - 1;
  }
}