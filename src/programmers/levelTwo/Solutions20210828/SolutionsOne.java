package programmers.levelTwo.Solutions20210828;

public class SolutionsOne {

  public int solution(int n) {
    int count = Integer.bitCount(n);
    int num = n + 1;
    while (true) {
      if (count == Integer.bitCount(num)) {
        return num;
      }
      num++;
    }
  }
}