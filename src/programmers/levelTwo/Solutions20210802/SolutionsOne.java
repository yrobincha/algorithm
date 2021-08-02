package programmers.levelTwo.Solutions20210802;

import java.util.ArrayList;

public class SolutionsOne {

  public int solution(String s) {
    if (s.length() <= 1) {
      return 0;
    }
    ArrayList<Character> characters = new ArrayList<>();

    int i = 0;
    while (i < s.length()) {
      if (characters.isEmpty()) {
        characters.add(s.charAt(i));
      } else if (characters.get(characters.size() - 1) == s.charAt(i)) {
        characters.remove(characters.size() - 1);
      } else {
        characters.add(s.charAt(i));
      }
      i++;
    }
    return characters.size() == 0 ? 1 : 0;
  }
}