package programmers.levelThree.Solutions20210924;

public class SolutionsTwo {

  public int[] solution(int n, int s) {
    int[] answer = new int[n];
    int index = 0;
    while (n > 0) {
      answer[index] = s / n;
      s -= answer[index++];
      n -= 1;
    }
    if (answer[0] == 0) {
      return new int[]{-1};
    }
    return answer;
  }
}