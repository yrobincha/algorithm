package programmers.levelOne.Solutions20210918;

import java.util.HashMap;

public class SolutionsTwo {

  public String solution(String[] table, String[] languages, int[] preference) {
    String answer = "SI";
    HashMap<String, Integer> score = new HashMap<>();
    for (String s : table) {
      String[] info = s.split(" ");
      HashMap<String, Integer> iMap = new HashMap<>();
      for (int i = 1; i < info.length; i++) {
        iMap.put(info[i], info.length - i);
      }

      int sum = 0;
      for (int i = 0; i < languages.length; i++) {
        sum += iMap.getOrDefault(languages[i], 0) * preference[i];
      }

      score.put(info[0], sum);

      if (score.get(answer) < sum) {
        answer = info[0];
      } else if (score.get(answer) == sum && answer.compareTo(info[0]) > 0) {
        answer = info[0];
      }
    }
    return answer;
  }
}