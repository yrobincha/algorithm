package backjoon.Solutions20211016;

import java.util.Scanner;

public class SolutionsTwo {

  int min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    SolutionsTwo solution = new SolutionsTwo();
    Scanner scanner = new Scanner(System.in);
    int N = 10;
    int[][] matrix = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    System.out.println(solution.solution(N, matrix));
  }

  int solution(int N, int[][] matrix) {
    int[] nums = new int[5];
    paper(N, matrix, nums, 0, 0, 0);

    if (min == Integer.MAX_VALUE) {
      return -1;
    } else {
      return min;
    }
  }

  void paper(int N, int[][] matrix, int[] nums, int x, int y, int cnt) {
    if (x >= 9 && y > 9) {
      min = Math.min(min, cnt);
      return;
    }

    if (min <= cnt) {
      return;
    }

    if (y > 9) {
      paper(N, matrix, nums, x + 1, 0, cnt);
      return;
    }

    if (matrix[x][y] == 1) {
      for (int plus = 4; plus >= 0; plus--) {
        if (x + plus < N && y + plus < N) {
          int count = 0;
          for (int m = x; m <= x + plus; m++) {
            for (int n = y; n <= y + plus; n++) {
              count += matrix[m][n];
            }
          }

          if (count == Math.pow(plus + 1, 2) && nums[plus] < 5) {
            nums[plus]++;
            attach(plus, matrix, x, y, 0);
            paper(N, matrix, nums, x, y + plus, cnt + 1);
            nums[plus]--;
            attach(plus, matrix, x, y, 1);
          }
        }
      }
    } else {
      paper(N, matrix, nums, x, y + 1, cnt);
    }
  }

  void attach(int plus, int[][] matrix, int x, int y, int value) {
    for (int i = x; i <= x + plus; i++) {
      for (int j = y; j <= y + plus; j++) {
        matrix[i][j] = value;
      }
    }
  }
}