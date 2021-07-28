package programmers.levelOne.Solutions20210728;

public class SolutionsOne {

  public String solution(String s) {
    StringBuilder answer = new StringBuilder();
    char gap = 'a' - 'A';
    int index = 0;
    for (int i = 0; i < s.length(); i++) {

      if (index % 2 == 0 && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
        answer.append((char) (s.charAt(i) - gap));
        index++;
      } else if (index % 2 == 1 && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
        answer.append((char) (s.charAt(i) + gap));
        index++;
      } else {
        if (s.charAt(i) == ' ') {
          index = 0;
        } else {
          index++;
        }
        answer.append(s.charAt(i));
      }
    }
    return answer.toString();
  }
}