package backjoon.Solutions20211015;

import java.util.Scanner;

public class SolutionsOne {

  int answer = 0;

  public static void main(String[] args) {
    SolutionsOne solution = new SolutionsOne();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    System.out.println(solution.solution(n, matrix));
  }

  int solution(int n, int[][] matrix) {
    findPath(n, matrix, 0, 0, 1);
    return answer;
  }

  void findPath(int n, int[][] matrix, int status, int x, int y) {
    if (x == n - 1 && y == n - 1) {
      answer++;
    } else {
      if (status == 0) {
        if (y + 1 < n && matrix[x][y + 1] == 0) {
          findPath(n, matrix, 0, x, y + 1);
        }
      } else if (status == 1) {
        if (x + 1 < n && matrix[x + 1][y] == 0) {
          findPath(n, matrix, 1, x + 1, y);
        }
      } else {
        if (x + 1 < n && matrix[x + 1][y] == 0) {
          findPath(n, matrix, 1, x + 1, y);
        }

        if (y + 1 < n && matrix[x][y + 1] == 0) {
          findPath(n, matrix, 0, x, y + 1);
        }
      }

      if (x + 1 < n && y + 1 < n
          && matrix[x][y + 1] == 0 && matrix[x + 1][y] == 0 && matrix[x + 1][y + 1] == 0) {
        findPath(n, matrix, 2, x + 1, y + 1);
      }
    }
  }
}