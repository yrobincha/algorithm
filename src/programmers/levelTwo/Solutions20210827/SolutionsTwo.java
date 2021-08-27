package programmers.levelTwo.Solutions20210827;

import java.util.ArrayList;

public class SolutionsTwo {

  boolean solution(String s) {
    ArrayList<Character> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (list.isEmpty()) {
        list.add(c);
      } else if (list.get(list.size() - 1) == '(' && c == ')') {
        list.remove(list.size() - 1);
      } else {
        list.add(c);
      }
    }

    return list.isEmpty();
  }
}