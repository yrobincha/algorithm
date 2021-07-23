package programmers.levelOne.Solutions20210723;

public class SolutionsFive {

  public String solution(String s) {
    if (s.length() % 2 == 0) {
      return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
    } else {
      return s.charAt(s.length() / 2) + "";
    }
  }
}