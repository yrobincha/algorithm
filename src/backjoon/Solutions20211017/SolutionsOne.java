package backjoon.Solutions20211017;

import java.util.ArrayList;
import java.util.Collections;
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
    int[] marbles = new int[4];
    int center = (N - 1) / 2;
    ArrayList<Marble> list = makeList(N, matrix);
    int[][] matrixMap = new int[N][N];
    int[][] listMap = new int[N * N][2];

    for (Marble m : list) {
      matrixMap[m.point[0]][m.point[1]] = m.num;
    }

    for (Marble m : list) {
      listMap[m.num] = new int[]{m.point[0], m.point[1]};
    }

    for (int[] magic : magics) {
      int d = magic[0];
      int s = magic[1];
      int bomb;

      if (d == 1) {
        for (int i = 1; i <= s; i++) {
          bomb = matrixMap[center - i][center];
          if (bomb < list.size()) {
            list.get(bomb).value = 0;
          }
        }
      } else if (d == 2) {
        for (int i = 1; i <= s; i++) {
          bomb = matrixMap[center + i][center];
          if (bomb < list.size()) {
            list.get(bomb).value = 0;
          }
        }
      } else if (d == 3) {
        for (int i = 1; i <= s; i++) {
          bomb = matrixMap[center][center - i];
          if (bomb < list.size()) {
            list.get(bomb).value = 0;
          }
        }
      } else if (d == 4) {
        for (int i = 1; i <= s; i++) {
          bomb = matrixMap[center][center + i];
          if (bomb < list.size()) {
            list.get(bomb).value = 0;
          }
        }
      }

      while (finishBomb(list)) {
        int current = 0;
        int size = 0;
        for (int i = 1; i < list.size(); i++) {
          Marble m = list.get(i);
          if (m.value == 0) {
            continue;
          }

          if (list.get(current).value == m.value) {
            size++;
          } else {
            if (size >= 4) {
              for (int k = current; k < i; k++) {
                marbles[list.get(k).value]++;
                list.get(k).value = 0;
              }
            }
            current = i;
            size = 1;
          }
        }

        if (size >= 4) {
          for (int k = current; k < list.size(); k++) {
            marbles[list.get(k).value]++;
            list.get(k).value = 0;
          }
        }

        matrix = new int[N][N];
        for (int i = 1; i < list.size(); i++) {
          Marble m = list.get(i);
          matrix[m.point[0]][m.point[1]] = m.value;
        }
      }

      ArrayList<Marble> tmp = new ArrayList<>();
      tmp.add(list.get(0));
      int current = 0;
      int size = 0;
      for (int i = 1; i < list.size() && tmp.size() < N * N; i++) {
        Marble m = list.get(i);
        if (m.value == 0) {
          continue;
        }

        if (current == m.value) {
          size++;
        } else {
          if (size > 0) {
            tmp.add(new Marble(tmp.size(), listMap[tmp.size()], size));
            tmp.add(new Marble(tmp.size(), listMap[tmp.size()], current));
          }

          current = m.value;
          size = 1;
        }
      }

      if (tmp.size() < N * N && size > 0) {
        tmp.add(new Marble(tmp.size(), listMap[tmp.size()], size));
        tmp.add(new Marble(tmp.size(), listMap[tmp.size()], current));
      }
      list = tmp;
    }

    int answer = 0;
    for (int i = 1; i < marbles.length; i++) {
      answer += i * marbles[i];
    }
    return answer;
  }

  boolean finishBomb(ArrayList<Marble> list) {
    int current = list.get(0).value;
    int size = 0;
    for (Marble m : list) {
      if (m.value == 0) {
        continue;
      }
      if (current == m.value) {
        size++;
        if (size == 4) {
          return true;
        }
      } else {
        current = m.value;
        size = 1;
      }
    }
    return false;
  }

  ArrayList<Marble> makeList(int N, int[][] matrix) {
    ArrayList<Marble> list = new ArrayList<>();
    int print = N;
    int k = 1;
    int right = -1;
    int bottom = 0;
    int top = 1;

    for (int i = N; i > 0; i--) {
      for (int j = 0; j < print; j++) {
        right = right + top;
        list.add(new Marble(N * N - k, new int[]{bottom, right}, matrix[bottom][right]));
        k++;
      }

      print--;

      for (int j = 0; j < print; j++) {
        bottom = bottom + top;
        list.add(new Marble(N * N - k, new int[]{bottom, right}, matrix[bottom][right]));
        k++;
      }

      top = top * (-1);
    }
    Collections.reverse(list);
    return list;
  }
}

class Marble {

  int num;
  int[] point;
  int value;

  public Marble(int num, int[] point, int value) {
    this.num = num;
    this.point = point;
    this.value = value;
  }
}