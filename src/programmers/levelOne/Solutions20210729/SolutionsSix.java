package programmers.levelOne.Solutions20210729;

public class SolutionsSix {

  public boolean solution(int x) {
    int originX = x;
    int sum = 0;
    while (x >= 9) {
      sum += x % 10;
      x /= 10;
    }
    sum += x;
    return originX % sum == 0;
  }
}