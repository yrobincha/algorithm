package programmers.levelTwo.Solutions20210805;

public class SolutionsOne {

  int m;
  int n;

  public int[] solution(int m, int n, int[][] picture) {
    this.m = m;
    this.n = n;
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    boolean[][] isVisited = new boolean[m][n];
    for (int i = 0; i < picture.length; i++) {
      for (int j = 0; j < picture[i].length; j++) {
        if (!isVisited[i][j] && picture[i][j] != 0) {
          numberOfArea++;
          int area = checkArea(picture, isVisited, i, j, picture[i][j]);
          if (area > maxSizeOfOneArea) {
            maxSizeOfOneArea = area;
          }
        }
      }
    }
    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }

  int checkArea(int[][] picture, boolean[][] isVisited, int x, int y, int color) {
    int area = 0;
    if (canAccess(x, y) && !isVisited[x][y] && picture[x][y] == color) {
      area++;
      isVisited[x][y] = true;
      area += checkArea(picture, isVisited, x - 1, y, color);
      area += checkArea(picture, isVisited, x, y - 1, color);
      area += checkArea(picture, isVisited, x + 1, y, color);
      area += checkArea(picture, isVisited, x, y + 1, color);
    }
    return area;
  }

  boolean canAccess(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}