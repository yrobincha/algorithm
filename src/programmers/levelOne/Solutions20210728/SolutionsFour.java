package programmers.levelOne.Solutions20210728;

import java.util.Arrays;

public class SolutionsFour {

  public long solution(long n) {
    char[] chars = (n + "").toCharArray();
    Arrays.sort(chars);
    StringBuilder s = new StringBuilder();
    s.append(chars);
    s.reverse();

    return Long.parseLong(s.toString());
  }
}