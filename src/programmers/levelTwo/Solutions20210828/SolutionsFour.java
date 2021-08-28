package programmers.levelTwo.Solutions20210828;

public class SolutionsFour {

  public String solution(String s) {
    StringBuilder answer = new StringBuilder();
    String[] numbers = s.split(" ");
    int max;
    int min;
    int num = Integer.parseInt(numbers[0]);
    max = num;
    min = num;

    for (String number : numbers) {
      num = Integer.parseInt(number);
      if (num > max) {
        max = num;
      }

      if (num < min) {
        min = num;
      }
    }
    return answer.append(min).append(" ").append(max).toString();
  }
}