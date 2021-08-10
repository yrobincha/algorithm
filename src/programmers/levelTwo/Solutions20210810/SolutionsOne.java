package programmers.levelTwo.Solutions20210810;

import java.util.HashMap;

public class SolutionsOne {

  public int[] solution(String s) {
    HashMap<String, Integer> tupleMap = new HashMap<>();
    s = s.replaceAll("\\{", "");
    s = s.replaceAll("}}", "");
    String[] tuples = s.split("},");
    for (String tuple : tuples) {
      String[] numbers = tuple.split(",");
      for (String num : numbers) {
        tupleMap.put(num, tupleMap.getOrDefault(num, 0) + 1);
      }
    }

    int[] answer = new int[tupleMap.size()];
    for (String key : tupleMap.keySet()) {
      answer[tupleMap.size() - tupleMap.get(key)] = Integer.parseInt(key);
    }
    return answer;
  }
}