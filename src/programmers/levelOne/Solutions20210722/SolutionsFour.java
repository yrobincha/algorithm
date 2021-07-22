package programmers.levelOne.Solutions20210722;

public class SolutionsFour {

  public int solution(int left, int right) {
    int answer = 0;
    for (int i = left; i <= right; i++) {
      int count = 0;
      for (int j = 1; j <= i; j++) {
        if (i % j == 0) {
          count++;
        }
      }
      answer += i * (count % 2 == 1 ? -1 : 1);
    }
    return answer;
  }
}