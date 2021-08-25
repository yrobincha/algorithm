package programmers.levelTwo.Solutions20210825;

import java.util.HashSet;

public class SolutionsSix {

  public int solution(String dirs) {
    int x = 0;
    int y = 0;
    HashSet<String> set = new HashSet<>();

    for (char c : dirs.toCharArray()) {
      String s = x + "" + y;
      if (c == 'U' && y < 5) {
        y++;
      } else if (c == 'R' && x < 5) {
        x++;
      } else if (c == 'D' && y > -5) {
        y--;
      } else if (c == 'L' && x > -5) {
        x--;
      } else {
        continue;
      }

      StringBuilder builder = new StringBuilder();
      builder.append(s).append(x).append(y);
      set.add(builder.toString());

      builder = new StringBuilder();
      builder.append(x).append(y).append(s);
      set.add(builder.toString());
    }
    return set.size() / 2;
  }
}