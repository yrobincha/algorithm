package programmers.levelTwo.Solutions20210806;

import java.util.HashMap;

public class SolutionsOne {

  public int solution(String str1, String str2) {
    HashMap<String, Integer> elements = new HashMap<>();
    HashMap<String, Integer> counts = new HashMap<>();

    int total = 0;
    for (int i = 0; i < str1.length() - 1; i++) {
      String s1 = str1.substring(i, i + 2).toLowerCase();
      if (!checkAvailable(s1)) {
        continue;
      }
      total++;
      elements.put(s1, elements.getOrDefault(s1, 0) + 1);
    }
    for (int j = 0; j < str2.length() - 1; j++) {
      String s2 = str2.substring(j, j + 2).toLowerCase();
      if (!checkAvailable(s2)) {
        continue;
      }
      total++;
      if (!elements.containsKey(s2)) {
        elements.put(s2, 1);
        counts.put(s2, 1);
      } else {
        counts.put(s2, counts.getOrDefault(s2, 0) + 1);
        if (counts.get(s2) > elements.get(s2)) {
          elements.put(s2, elements.get(s2) + 1);
        }
      }
    }

    int uSize = 0;
    for (String s : elements.keySet()) {
      uSize += elements.get(s);
    }

    if (total == 0) {
      return 65536;
    } else {
      return (int) ((total - uSize) * 65536.0 / uSize);
    }
  }

  boolean checkAvailable(String s) {
    return s.charAt(0) >= 'a' && s.charAt(0) <= 'z' && s.charAt(1) >= 'a' && s.charAt(1) <= 'z';
  }
}