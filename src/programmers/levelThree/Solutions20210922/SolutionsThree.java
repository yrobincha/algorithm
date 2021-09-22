package programmers.levelThree.Solutions20210922;

import java.util.Arrays;

public class SolutionsThree {

  public int solution(int n, int[] money) {
    int div = 1000000007;
    Arrays.sort(money);
    int[] d = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      if (i % money[0] == 0) {
        d[i] = 1;
      }
    }

    for (int i = 1; i < money.length; i++) {
      for (int j = money[i]; j <= n; j++) {
        d[j] = (d[j] % div + d[j - money[i]] % div) % div;
      }
    }

    return d[n];
  }
}