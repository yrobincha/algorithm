package programmers.levelTwo.Solutions20210819;

public class SolutionsOne {

  public String solution(String number, int k) {
    StringBuilder answer = new StringBuilder();
    int index = 0;
    while (answer.length() < number.length() - k) {
      char max = '0';
      for (int i = index; i <= k + answer.length(); i++) {
        char c = number.charAt(i);
        if (c > max) {
          max = c;
          index = i + 1;
        }
      }
      answer.append(max);
    }
    return answer.toString();
  }
}