package programmers.levelOne.Solutions20211007;

public class SolutionsOne {

  public int solution(int[][] sizes) {
    int width = 0;
    int height = 0;
    for (int[] size : sizes) {
      int max = Math.max(size[0], size[1]);
      int min = Math.min(size[0], size[1]);
      if (max > width) {
        width = max;
      }
      if (min > height) {
        height = min;
      }
    }
    return width * height;
  }
}