package programmers.levelOne.Solutions20210720;

import java.util.HashMap;

public class SolutionSix {

  public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> map = new HashMap<>();

    for (String c : completion) {
      map.put(c, map.getOrDefault(c, 0) - 1);
    }

    for (String p : participant) {
      map.put(p, map.getOrDefault(p, 0) + 1);
      if (map.get(p) > 0) {
        return p;
      }
    }

    return answer;
  }
}