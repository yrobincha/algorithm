package programmers.levelTwo.Solutions20210811;

import java.util.ArrayList;

public class SolutionsOne {

  public String solution(String p) {
    if (checkString(p)) {
      return p;
    } else {
      return makeString(p);
    }
  }

  String makeString(String s) {
    if (s.isEmpty()) {
      return s;
    }
    StringBuilder answer = new StringBuilder();
    int index = getSplitIndex(s);
    String u = s.substring(0, index + 1);
    if (checkString(u)) {
      answer.append(u);
      answer.append(makeString(s.substring(index + 1)));
    } else {
      answer.append('(');
      answer.append(makeString(s.substring(index + 1)));
      answer.append(')');
      StringBuilder builder = new StringBuilder(u);
      for (int i = 0; i < u.length(); i++) {
        if (u.charAt(i) == '(') {
          builder.setCharAt(i, ')');
        } else {
          builder.setCharAt(i, '(');
        }
      }
      answer.append(builder, 1, u.length() - 1);
    }
    return answer.toString();
  }

  boolean checkString(String s) {
    ArrayList<Character> characters = new ArrayList<>();
    for (char c : s.toCharArray()) {
      if (characters.isEmpty()) {
        characters.add(c);
      } else {
        if (characters.get(characters.size() - 1) == '(' && c == ')') {
          characters.remove(characters.size() - 1);
        } else {
          characters.add(c);
        }
      }
    }
    return characters.isEmpty();
  }

  int getSplitIndex(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else {
        count--;
      }

      if (count == 0) {
        return i;
      }
    }
    return 0;
  }
}