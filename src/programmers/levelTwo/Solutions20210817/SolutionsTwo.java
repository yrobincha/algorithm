package programmers.levelTwo.Solutions20210817;

public class SolutionsTwo {

  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
    int s = brown + yellow;
    for (int n = 3; n <= s / 2; n++) {
      if (s % n == 0) {
        int m = s / n;
        if (n + m == brown / 2 + 2 && m >= n) {
          answer[0] = m;
          answer[1] = n;
          break;
        }
      }
    }
    return answer;
  }
}