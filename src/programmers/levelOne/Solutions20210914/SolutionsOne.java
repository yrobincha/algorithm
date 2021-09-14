package programmers.levelOne.Solutions20210914;

public class SolutionsOne {

  public int solution(int[] numbers) {
    boolean[] check = new boolean[10];
    for (int number : numbers) {
      check[number] = true;
    }
    int answer = 45;
    for (int i = 0; i < check.length; i++) {
      answer -= check[i] ? i : 0;
    }
    return answer;
  }
}