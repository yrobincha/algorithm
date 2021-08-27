package programmers.levelTwo.Solutions20210827;

public class SolutionsThree {

  public String solution(int n, int t, int m, int p) {
    StringBuilder answer = new StringBuilder();
    int i = 0;
    while (answer.length() < t * m) {
      String s;
      if (n == 2) {
        s = Integer.toBinaryString(i);
      } else if (n == 8) {
        s = Integer.toOctalString(i);
      } else if (n == 10) {
        s = i + "";
      } else {
        s = makeString(n, i);
      }
      if (answer.length() + s.length() <= t * m) {
        answer.append(s);
      } else {
        answer.append(s, 0, t * m - answer.length());
      }
      i++;
    }

    for (int j = answer.length() - 1; j >= 0; j--) {
      if (j % m != p - 1) {
        answer.replace(j, j + 1, "");
      }
    }
    return answer.toString();
  }

  String makeString(int n, int i) {
    if (i == 0) {
      return "0";
    }
    String[] nums = new String[]{"A", "B", "C", "D", "E", "F"};
    StringBuilder builder = new StringBuilder();
    while (i > 0) {
      int d = i % n;
      if (d >= 10) {
        builder.append(nums[d - 10]);
      } else {
        builder.append(d);
      }
      i /= n;
    }
    return builder.reverse().toString();
  }
}