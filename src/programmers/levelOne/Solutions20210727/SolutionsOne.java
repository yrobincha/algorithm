package programmers.levelOne.Solutions20210727;

public class SolutionsOne {

  public int solution(int n) {
    boolean[] notPrime = new boolean[n - 2 + 1];
    int answer = 0;
    for (int i = 0; i < notPrime.length; i++) {
      int num = i;
      if (!notPrime[num]) {
        while (num < notPrime.length) {
          notPrime[num] = true;
          num += i + 2;
        }
        answer++;
      }
    }
    return answer;
  }
}