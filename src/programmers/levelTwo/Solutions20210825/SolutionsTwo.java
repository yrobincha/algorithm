package programmers.levelTwo.Solutions20210825;

public class SolutionsTwo {

  public int[] solution(String s) {
    int[] answer = new int[]{0, 0};
    StringBuilder builder = new StringBuilder(s);
    while (!builder.toString().equals("1")) {
      for (int i = builder.length() - 1; i >= 0; i--) {
        if (builder.charAt(i) == '0') {
          answer[1]++;
          builder.replace(i, i + 1, "");
        }
      }
      builder = new StringBuilder(Integer.toBinaryString(builder.length()));
      answer[0]++;
    }
    return answer;
  }
}