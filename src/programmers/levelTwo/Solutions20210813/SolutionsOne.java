package programmers.levelTwo.Solutions20210813;

public class SolutionsOne {

  public int solution(int n, int a, int b) {
    int answer = 0;
    while (a != b) {
      a = (a + (a % 2 == 1 ? 1 : 0)) / 2;
      b = (b + (b % 2 == 1 ? 1 : 0)) / 2;
      answer++;
    }
    return answer;
  }
}