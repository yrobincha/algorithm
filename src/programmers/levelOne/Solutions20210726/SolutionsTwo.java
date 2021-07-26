package programmers.levelOne.Solutions20210726;

import java.util.Arrays;

public class SolutionsTwo {

  public String solution(String s) {
    char[] answer = s.toCharArray();
    Arrays.sort(answer);
    StringBuilder stringBuilder = new StringBuilder();
    return stringBuilder.append(answer).reverse().toString();
  }
}