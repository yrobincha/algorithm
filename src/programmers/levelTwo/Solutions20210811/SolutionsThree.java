package programmers.levelTwo.Solutions20210811;

public class SolutionsThree {

  public int solution(int[] arr) {
    int answer = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int plus = Math.max(answer, arr[i]);
      int n = plus;
      while (n % answer != 0 && n % arr[i] != 0) {
        n += plus;
      }
      answer = n;
    }
    return answer;
  }
}