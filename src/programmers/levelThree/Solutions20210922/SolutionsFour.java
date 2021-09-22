package programmers.levelThree.Solutions20210922;

public class SolutionsFour {

  public long solution(int n) {
    if (n == 1) {
      return 1;
    }
    long[] answer = new long[n];
    answer[0] = 1;
    answer[1] = 2;
    for (int i = 2; i < n; i++) {
      answer[i] = (answer[i - 1] % 1234567 + answer[i - 2] % 1234567) % 1234567;
    }
    return answer[n - 1];
  }
}