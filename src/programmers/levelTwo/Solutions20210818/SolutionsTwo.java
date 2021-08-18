package programmers.levelTwo.Solutions20210818;

import java.util.ArrayList;

public class SolutionsTwo {

  public int solution(String s) {
    int answer = 0;
    StringBuilder builder = new StringBuilder(s);
    for (int i = 0; i < s.length(); i++) {
      builder.append(builder.charAt(0));
      builder.replace(0, 1, "");
      ArrayList<Character> characters = new ArrayList<>();
      for (int j = 0; j < builder.length(); j++) {
        char c1 = builder.charAt(j);
        if (characters.isEmpty()) {
          characters.add(c1);
        } else {
          char c2 = characters.get(characters.size() - 1);
          if (c1 - c2 > 0 && c1 - c2 <= 2) {
            characters.remove(characters.size() - 1);
          } else {
            characters.add(c1);
          }
        }
      }
      answer += characters.isEmpty() ? 1 : 0;
    }
    return answer;
  }
}