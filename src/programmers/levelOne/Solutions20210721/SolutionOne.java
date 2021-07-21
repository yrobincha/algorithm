package programmers.levelOne.Solutions20210721;

public class SolutionOne {

  public int solution(String s) {
    String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine"};

    for (int i = 0; i < numbers.length; i++) {
      if (s.contains(numbers[i])) {
        s = s.replaceAll(numbers[i], i + "");
      }
    }
    return Integer.parseInt(s);
  }
}