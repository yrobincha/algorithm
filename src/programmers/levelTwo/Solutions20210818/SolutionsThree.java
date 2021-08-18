package programmers.levelTwo.Solutions20210818;

import java.util.ArrayList;

public class SolutionsThree {

  public int solution(String[][] relation) {
    int answer = 0;
    ArrayList<String> keys = new ArrayList<>();
    for (int i = 0; i < (1 << relation[0].length); i++) {
      StringBuilder key = new StringBuilder();
      for (int j = 0; j < relation[0].length; j++) {
        if ((i & (1 << j)) > 0) {
          key.append(j);
        }
      }
      keys.add(key.toString());
    }

    while (!keys.isEmpty()) {
      String key = keys.get(0);
      boolean check1 = true;
      for (int i = 0; i < relation.length - 1; i++) {
        for (int j = i + 1; j < relation.length; j++) {
          StringBuilder s1 = new StringBuilder();
          StringBuilder s2 = new StringBuilder();
          for (int k = 0; k < key.length(); k++) {
            int index = key.charAt(k) - '0';
            s1.append(relation[i][index]);
            s2.append(relation[j][index]);
          }
          check1 = check1 && !s1.toString().equals(s2.toString());
        }
      }
      keys.remove(0);
      if (check1) {
        answer++;
        for (int i = keys.size() - 1; i >= 0; i--) {
          boolean check2 = true;
          for (char c : key.toCharArray()) {
            check2 = check2 && keys.get(i).contains(c + "");
          }
          if (check2) {
            keys.remove(i);
          }
        }
      }
    }
    return answer;
  }
}