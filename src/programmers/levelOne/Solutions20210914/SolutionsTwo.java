package programmers.levelOne.Solutions20210914;

public class SolutionsTwo {

  public long solution(int price, int money, int count) {
    long answer = money;
    for (int i = 0; i < count; i++) {
      answer -= (long) price * (i + 1);
    }
    return answer < 0 ? Math.abs(answer) : 0;
  }
}