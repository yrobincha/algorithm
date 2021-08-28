package programmers.levelTwo.Solutions20210828;

public class SolutionsThree {

  public int solution(int n) {
    int answer = 1;
    for (int i = 1; i <= n; i++) {
      int sum = i;
      for (int j = i + 1; j <= n; j++) {
        sum += j;
        if (sum == n) {
          answer += 1;
          break;
        } else if (sum > n) {
          break;
        }
      }
    }
    return answer;
  }
}