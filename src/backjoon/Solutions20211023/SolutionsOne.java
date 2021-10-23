package backjoon.Solutions20211023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SolutionsOne {

  public static void main(String[] args) {
    SolutionsOne solution = new SolutionsOne();
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[][] matrix = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    System.out.println(solution.solution(N, matrix));
  }

  int solution(int N, int[][] matrix) {
    int answer = 0;
    int[][][] rates = new int[][][]{
        {{-2, 0, 2}, {-1, -1, 10}, {-1, 0, 7}, {-1, 1, 1},
            {0, -2, 5}, {0, -1, -1}, {2, 0, 2}, {1, -1, 10}, {1, 0, 7}, {1, 1, 1}},

        {{0, -2, 2}, {1, 1, 10}, {0, -1, 7}, {-1, -1, 1},
            {2, 0, 5}, {1, 0, -1}, {0, 2, 2}, {1, -1, 10}, {0, 1, 7}, {-1, 1, 1}},

        {{-2, 0, 2}, {-1, 1, 10}, {-1, 0, 7}, {-1, -1, 1},
            {0, 2, 5}, {0, 1, -1}, {2, 0, 2}, {1, 1, 10}, {1, 0, 7}, {1, -1, 1}},

        {{0, -2, 2}, {-1, -1, 10}, {0, -1, 7}, {1, -1, 1},
            {-2, 0, 5}, {-1, 0, -1}, {0, 2, 2}, {-1, 1, 10}, {0, 1, 7}, {1, 1, 1}}};
    int x = N / 2;
    int y = N / 2 - 1;

    ArrayList<Sand> sands = makeSands(N, matrix);
    int[][] map = new int[N][N];
    for (Sand s : sands) {
      map[s.point[0]][s.point[1]] = s.number;
    }

    int d = 0;
    while (x >= 0 && y >= 0) {
      Sand sand = sands.get(map[x][y]);
      int[] alpha = new int[]{-1, -1};
      int minus = 0;
      for (int[] rate : rates[d]) {
        int tx = x + rate[0];
        int ty = y + rate[1];
        if (rate[2] < 0) {
          alpha = new int[]{tx, ty};
          continue;
        }

        int value = sand.value * rate[2] / 100;

        if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
          Sand plus = sands.get(map[tx][ty]);
          plus.value += value;
        } else {
          answer += value;
        }
        minus += value;
      }

      sand.value -= minus;
      if (alpha[0] >= 0 && alpha[0] < N && alpha[1] >= 0 && alpha[1] < N) {
        Sand plus = sands.get(map[alpha[0]][alpha[1]]);
        plus.value += sand.value;
      } else {
        answer += sand.value;
      }
      sand.value = 0;

      if (x == 0 && y == 0) {
        break;
      }
      int[] next = sands.get(map[x][y] + 1).point;
      if (x - next[0] > 0) {
        d = 3;
      } else if (x - next[0] < 0) {
        d = 1;
      } else if (y - next[1] > 0) {
        d = 0;
      } else {
        d = 2;
      }
      x = next[0];
      y = next[1];
    }
    return answer;
  }

  ArrayList<Sand> makeSands(int N, int[][] matrix) {
    ArrayList<Sand> sands = new ArrayList<>();
    int print = N;
    int k = 1;
    int right = -1;
    int bottom = 0;
    int top = 1;

    for (int i = N; i > 0; i--) {
      for (int j = 0; j < print; j++) {
        right = right + top;
        sands.add(new Sand(N * N - k, new int[]{bottom, right}, matrix[bottom][right]));
        k++;
      }

      print--;

      for (int j = 0; j < print; j++) {
        bottom = bottom + top;
        sands.add(new Sand(N * N - k, new int[]{bottom, right}, matrix[bottom][right]));
        k++;
      }

      top = top * (-1);
    }
    Collections.reverse(sands);
    return sands;
  }
}

class Sand {

  int number;
  int[] point;
  int value;

  public Sand(int number, int[] point, int value) {
    this.number = number;
    this.point = point;
    this.value = value;
  }
}