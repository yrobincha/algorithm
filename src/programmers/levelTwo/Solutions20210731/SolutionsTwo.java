package programmers.levelTwo.Solutions20210731;

public class SolutionsTwo {

  public String solution(int n) {
    StringBuilder answer = new StringBuilder();
    String[] num = new String[]{"4", "1", "2"};
    while (n > 0) {
      answer.append(num[n % 3]);
      if (n % 3 == 0) {
        n -= 1;
      }
      n /= 3;
    }
    return answer.reverse().toString();
  }
}