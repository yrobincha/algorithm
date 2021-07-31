package programmers.levelTwo.Solutions20210731;

public class SolutionsOne {

  public int solution(String s) {
    StringBuilder answer = new StringBuilder(s);
    for (int i = 1; i < s.length(); i++) {
      StringBuilder result = new StringBuilder();
      String split = s.substring(0, i);
      int beginIndex = i;
      int count = 1;
      while (beginIndex + i <= s.length()) {
        String sub = s.substring(beginIndex, beginIndex + i);
        if (split.equals(sub)) {
          count++;
        } else {
          if (count >= 2) {
            result.append(count).append(split);
          } else {
            result.append(split);
          }
          split = sub;
          count = 1;
        }
        beginIndex += i;
      }
      if (count >= 2) {
        result.append(count).append(split);
      } else {
        result.append(split);
      }
      result.append(s.substring(beginIndex));
      if (result.length() < answer.length()) {
        answer = result;
      }
    }
    return answer.length();
  }
}