package programmers.levelOne.Solutions20210727;

public class SolutionsFour {

  public String solution(String s, int n) {
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        if (c + n > 'z') {
          c = (char) (c - 'z' + 'a' + n - 1);
        } else if (c <= 'Z' && c + n > 'Z') {
          c = (char) (c - 'Z' + 'A' + n - 1);
        } else {
          c = (char) (c + n);
        }
      }
      answer.append(c);
    }
    return answer.toString();
  }
}