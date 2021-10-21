package backjoon.Solutions20211021;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SolutionsOne {

  public static void main(String[] args) {
    SolutionsOne solution = new SolutionsOne();
    Scanner scanner = new Scanner(System.in);

    int N = (int) Math.pow(2, scanner.nextInt());
    int Q = scanner.nextInt();
    int[][] matrix = new int[N][N];
    int[] magics = new int[Q];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    for (int i = 0; i < Q; i++) {
      magics[i] = scanner.nextInt();
    }

    int[] answer = solution.solution(N, matrix, magics);
    System.out.println(answer[0] + "\n" + answer[1]);
  }

  int[] solution(int N, int[][] matrix, int[] magics) {
    int[][] ds = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int magic : magics) {
      int gap = (int) Math.pow(2, magic);
      Queue<int[]> points = new LinkedList<>();
      for (int i = 0; i < N; i += gap) {
        for (int j = 0; j < N; j += gap) {
          points.add(new int[]{i, j});
        }
      }

      while (!points.isEmpty()) {
        int[] point = points.poll();
        int x = point[0];
        int y = point[1];
        int[][] tmp = new int[gap][gap];
        for (int i = 0; i < tmp.length; i++) {
          for (int j = 0; j < tmp[i].length; j++) {
            tmp[j][tmp.length - i - 1] = matrix[x + i][y + j];
          }
        }

        for (int i = 0; i < tmp.length; i++) {
          System.arraycopy(tmp[i], 0, matrix[x + i], y, tmp[i].length);
        }
      }

      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          int count = 0;
          for (int[] d : ds) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < N && y >= 0 && y < N && matrix[x][y] > 0) {
              count++;
            }
          }
          if (count < 3) {
            points.add(new int[]{i, j});
          }
        }
      }

      while (!points.isEmpty()) {
        int[] point = points.poll();
        if (matrix[point[0]][point[1]] > 0) {
          matrix[point[0]][point[1]] -= 1;
        }
      }
    }

    int sum = 0;
    int maxArea = 0;
    boolean[][] visited = new boolean[N][N];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        sum += matrix[i][j];
        if (matrix[i][j] > 0 && !visited[i][j]) {
          int area = getArea(N, i, j, visited, matrix);
          maxArea = Math.max(maxArea, area);
        }
      }
    }

    return new int[]{sum, maxArea};
  }

  int getArea(int N, int x, int y, boolean[][] visited, int[][] matrix) {
    int sum = 0;
    if (x >= 0 && x < N && y >= 0 && y < N && matrix[x][y] > 0 && !visited[x][y]) {
      sum++;
      visited[x][y] = true;
      sum += getArea(N, x - 1, y, visited, matrix);
      sum += getArea(N, x + 1, y, visited, matrix);
      sum += getArea(N, x, y - 1, visited, matrix);
      sum += getArea(N, x, y + 1, visited, matrix);
    }
    return sum;
  }
}