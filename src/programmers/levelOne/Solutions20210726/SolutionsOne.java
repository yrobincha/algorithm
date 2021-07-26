package programmers.levelOne.Solutions20210726;

import java.util.Locale;

public class SolutionsOne {

  boolean solution(String s) {
    int count = 0;
    s = s.toLowerCase(Locale.ROOT);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'y') {
        count++;
      } else if (s.charAt(i) == 'p') {
        count--;
      }
    }

    return count == 0;
  }
}