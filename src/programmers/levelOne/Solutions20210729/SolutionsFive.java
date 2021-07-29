package programmers.levelOne.Solutions20210729;

public class SolutionsFive {

  public double solution(int[] arr) {
    double answer = 0;
    for (int n : arr) {
      answer += n;
    }
    return answer / arr.length;
  }
}