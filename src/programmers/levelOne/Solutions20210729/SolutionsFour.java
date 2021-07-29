package programmers.levelOne.Solutions20210729;

public class SolutionsFour {

  public long solution(long num) {
    int answer = 0;
    while (num != 1 && answer < 500) {
      if (num % 2 == 0) {
        num /= 2;
      } else {
        num = num * 3 + 1;
      }
      answer++;
    }
    if (answer >= 500) {
      return -1;
    } else {
      return answer;
    }
  }
}