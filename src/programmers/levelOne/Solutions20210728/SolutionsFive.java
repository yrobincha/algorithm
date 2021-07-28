package programmers.levelOne.Solutions20210728;

public class SolutionsFive {

  public long solution(long n) {
    double d = Math.sqrt(n);
    if (d > (long) d || d < (long) d) {
      return -1;
    } else {
      return (long) Math.pow((long) d + 1, 2);
    }
  }
}