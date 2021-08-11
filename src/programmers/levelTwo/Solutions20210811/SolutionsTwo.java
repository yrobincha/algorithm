package programmers.levelTwo.Solutions20210811;

public class SolutionsTwo {

  public String solution(String s) {
    s = s.toLowerCase();
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ((i == 0 || (i > 1 && s.charAt(i - 1) == ' ')) && c >= 'a' && c <= 'z') {
        answer.append((char) (c - 'a' + 'A'));
      } else {
        answer.append(c);
      }
    }
    return answer.toString();
  }
}