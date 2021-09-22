package programmers.levelThree.Solutions20210922;

public class SolutionsTwo {

  public int solution(String s) {
    int answer = 1;
    for (int i = s.length(); i >= 2; i--) {
      for (int j = 0; j <= s.length() - i; j++) {
        int start = j;
        int end = j + i - 1;
        while (start < end) {
          if (s.charAt(start) != s.charAt(end)) {
            break;
          }
          start++;
          end--;
        }
        if (start >= end) {
          return i;
        }
      }
    }
    return answer;
  }
}