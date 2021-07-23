package programmers.levelOne.Solutions20210723;

public class SolutionsNine {

  public long solution(int a, int b) {
    long answer = 0;
    for (long n = Math.min(a, b); n <= Math.max(a, b); n++) {
      answer += n;
    }
    return answer;
  }
}