package programmers.levelThree.Solutions20210903;

public class SolutionsThree {

  public int solution(int[][] triangle) {
    int answer = 0;
    for (int i = 1; i < triangle.length; i++) {
      for (int j = 0; j < triangle[i].length; j++) {
        int max;
        if (j == 0) {
          max = triangle[i - 1][j];
        } else if (j < triangle[i].length - 1) {
          max = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
        } else {
          max = triangle[i - 1][j - 1];
        }
        triangle[i][j] += max;
        if (answer < triangle[i][j]) {
          answer = triangle[i][j];
        }
      }
    }
    return answer;
  }
}