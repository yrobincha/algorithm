package programmers.levelOne.Solutions20210726;

public class SolutionsThree {

  public boolean solution(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) < '0' || s.charAt(i) > '9') {
        return false;
      }
    }
    return s.length() == 4 || s.length() == 6;
  }
}