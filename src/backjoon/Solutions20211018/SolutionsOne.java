package backjoon.Solutions20211018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SolutionsOne {

  public static void main(String[] args) {
    SolutionsOne solution = new SolutionsOne();
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int[][] matrix = new int[N][N];
    int[][] magics = new int[M][2];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    for (int i = 0; i < M; i++) {
      magics[i][0] = scanner.nextInt();
      magics[i][1] = scanner.nextInt();
    }

    System.out.println(solution.solution(N, matrix, magics));
  }

  int solution(int N, int[][] matrix, int[][] magics) {
    int[][] ds = new int[][]{{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    int[][] cross = new int[][]{{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    Queue<int[]> queue = makeQueue(N);

    for (int[] magic : magics) {
      boolean[][] done = new boolean[N][N];
      int[] d = ds[magic[0] - 1];
      while (!queue.isEmpty()) {
        int[] point = queue.poll();
        int x = point[0] + magic[1] % N * d[0];
        int y = point[1] + magic[1] % N * d[1];
        if (x < 0) {
          x += N;
        } else if (x >= N) {
          x -= N;
        }

        if (y < 0) {
          y += N;
        } else if (y >= N) {
          y -= N;
        }

        done[x][y] = true;
        matrix[x][y]++;
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (done[i][j]) {
            for (int[] c : cross) {
              int m = i + c[0];
              int n = j + c[1];
              if (m >= 0 && m < N && n >= 0 && n < N && matrix[m][n] > 0) {
                matrix[i][j]++;
              }
            }
          }
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!done[i][j] && matrix[i][j] >= 2) {
            matrix[i][j] -= 2;
            queue.add(new int[]{i, j});
          }
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        answer += matrix[i][j];
      }
    }
    return answer;
  }

  Queue<int[]> makeQueue(int N) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{N - 2, 0});
    queue.add(new int[]{N - 2, 1});
    queue.add(new int[]{N - 1, 0});
    queue.add(new int[]{N - 1, 1});

    return queue;
  }
}