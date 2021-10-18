package backjoon.Solutions20211018;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionsTwo {

  public static void main(String[] args) {
    SolutionsTwo solution = new SolutionsTwo();
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int[][] matrix = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    System.out.println(solution.solution(N, M, matrix));
  }

  int solution(int N, int M, int[][] matrix) {
    int answer = 0;
    boolean check = true;
    while (check) {
      Group max = null;
      boolean[][] visited = new boolean[N][N];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && matrix[i][j] >= 0 && matrix[i][j] != Integer.MAX_VALUE) {
            ArrayList<int[]> points = new ArrayList<>();
            Group group = findGroup(N, matrix, new int[M + 1], visited, i, j, matrix[i][j],
                new int[]{i, j}, points);
            if (group.size > group.blocks[0]) {
              max = compareGroup(max, group);
            }

            for (int[] point : points) {
              int x = point[0];
              int y = point[1];
              if (matrix[x][y] == 0) {
                visited[x][y] = false;
              }
            }
          }

          check = max != null;
        }
      }

      if (max != null) {
        for (int[] point : max.points) {
          matrix[point[0]][point[1]] = Integer.MAX_VALUE;
        }
        answer += Math.pow(max.points.size(), 2);

        down(N, matrix);
        matrix = rotate(N, matrix);
        down(N, matrix);
      }
    }
    return answer;
  }

  Group findGroup(int N, int[][] matrix, int[] blocks, boolean[][] visited, int x, int y,
      int value, int[] standard, ArrayList<int[]> points) {
    int size = 0;
    if (canAccess(x, y, N) && !visited[x][y] && (matrix[x][y] == value || matrix[x][y] == 0)) {
      size++;
      visited[x][y] = true;
      blocks[matrix[x][y]]++;
      points.add(new int[]{x, y});

      size += findGroup(N, matrix, blocks, visited, x - 1, y, value, standard, points).size;
      size += findGroup(N, matrix, blocks, visited, x + 1, y, value, standard, points).size;
      size += findGroup(N, matrix, blocks, visited, x, y - 1, value, standard, points).size;
      size += findGroup(N, matrix, blocks, visited, x, y + 1, value, standard, points).size;
    }
    return new Group(size, blocks, standard, points);
  }

  boolean canAccess(int x, int y, int N) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }

  void down(int N, int[][] matrix) {
    for (int j = 0; j < N; j++) {
      for (int i = N - 2; i >= 0; i--) {
        if (matrix[i][j] != Integer.MAX_VALUE && matrix[i][j] >= 0) {
          int target = N - 1;
          for (int k = i + 1; k < N; k++) {
            if (matrix[k][j] != Integer.MAX_VALUE) {
              target = k - 1;
              break;
            }
          }

          if (target != i) {
            matrix[target][j] = matrix[i][j];
            matrix[i][j] = Integer.MAX_VALUE;
          }
        }
      }
    }
  }

  int[][] rotate(int N, int[][] matrix) {
    int[][] tmp = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        tmp[i][j] = Integer.MAX_VALUE;
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        tmp[N - 1 - j][i] = matrix[i][j];
      }
    }
    return tmp;
  }

  Group compareGroup(Group max, Group group) {
    if (max == null) {
      if (group.size > 1) {
        return group;
      } else {
        return null;
      }
    }

    if (max.size < group.size) {
      return group;
    } else if (max.size == group.size) {
      if (max.blocks[0] < group.blocks[0]) {
        return group;
      } else if (max.blocks[0] == group.blocks[0]) {
        if (max.standard[0] < group.standard[0]) {
          return group;
        } else if (max.standard[0] == group.standard[0]) {
          if (max.standard[1] < group.standard[1]) {
            return group;
          }
        }
      }
    }
    return max;
  }
}

class Group {

  int size;
  int[] blocks;
  int[] standard;
  ArrayList<int[]> points;

  public Group(int size, int[] blocks, int[] standard, ArrayList<int[]> points) {
    this.size = size;
    this.blocks = blocks;
    this.standard = standard;
    this.points = points;
  }
}