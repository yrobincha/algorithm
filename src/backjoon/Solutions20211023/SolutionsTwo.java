package backjoon.Solutions20211023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SolutionsTwo {

  public static void main(String[] args) {
    SolutionsTwo solution = new SolutionsTwo();
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int K = scanner.nextInt();

    Queue<FireBall> queue = new LinkedList<>();
    for (int i = 0; i < M; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      int m = scanner.nextInt();
      int s = scanner.nextInt();
      int d = scanner.nextInt();
      queue.add(new FireBall(x - 1, y - 1, m, s, d));
    }

    System.out.println(solution.solution(queue, N, K));
  }

  int solution(Queue<FireBall> queue, int N, int K) {
    int[][] ds = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    for (int i = 0; i < K; i++) {
      HashMap<String, ArrayList<FireBall>> map = new HashMap<>();
      while (!queue.isEmpty()) {
        FireBall fireBall = queue.poll();
        int[] td = ds[fireBall.d];
        int[] point = getPoint(N, fireBall.x, fireBall.y, fireBall.s, td);

        String key = point[0] + "," + point[1];
        ArrayList<FireBall> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new FireBall(point[0], point[1], fireBall.m, fireBall.s, fireBall.d));
        map.put(key, list);
      }

      for (String key : map.keySet()) {
        ArrayList<FireBall> list = map.get(key);
        if (list.size() == 1) {
          queue.add(list.get(0));
          continue;
        }
        int mSum = 0;
        int sSum = 0;
        int dSum = 0;
        for (FireBall ball : list) {
          mSum += ball.m;
          sSum += ball.s;
          dSum += ball.d % 2;
        }

        if (mSum >= 5) {
          int m = mSum / 5;
          int s = sSum / list.size();
          int index = 0;
          if (dSum > 0 && dSum < list.size()) {
            index = 1;
          }

          int x = list.get(0).x;
          int y = list.get(0).y;
          for (; index < 8; index += 2) {
            queue.add(new FireBall(x, y, m, s, index));
          }
        }
      }
    }

    int sum = 0;
    while (!queue.isEmpty()) {
      sum += queue.poll().m;
    }
    return sum;
  }

  int[] getPoint(int N, int x, int y, int s, int[] td) {
    int tx = x + s % N * td[0];
    int ty = y + s % N * td[1];
    if (tx < 0) {
      tx += N;
    } else if (tx >= N) {
      tx -= N;
    }

    if (ty < 0) {
      ty += N;
    } else if (ty >= N) {
      ty -= N;
    }

    return new int[]{tx, ty};
  }
}

class FireBall {

  int x;
  int y;
  int m;
  int s;
  int d;

  public FireBall(int x, int y, int m, int s, int d) {
    this.x = x;
    this.y = y;
    this.m = m;
    this.s = s;
    this.d = d;
  }
}