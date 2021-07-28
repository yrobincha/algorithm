package programmers.levelOne.Solutions20210728;

public class SolutionsTwo {

  public int solution(int n) {
    int answer = 0;
    while (n > 9) {
      answer += n % 10;
      n /= 10;
    }

    return answer + n;
  }
}