package backjoon.Solutions20211018;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SolutionsThree {

  public static void main(String[] args) {
    SolutionsThree solution = new SolutionsThree();
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    HashMap<Integer, int[]> map = new HashMap<>();
    int[][] matrix = new int[N][N];
    int[] nums = new int[N * N];

    for (int i = 0; i < N * N; i++) {
      int key = scanner.nextInt();
      nums[i] = key;
      map.put(key, new int[4]);
      for (int j = 0; j < 4; j++) {
        int[] favorite = map.get(key);
        favorite[j] = scanner.nextInt();
        map.put(key, favorite);
      }
    }

    System.out.println(solution.solution(N, map, matrix, nums));
  }

  int solution(int N, HashMap<Integer, int[]> map, int[][] matrix, int[] nums) {
    int[][] sides = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    HashMap<Integer, int[]> seats = new HashMap<>();
    for (int num : nums) {
      int[] favorites = map.get(num);
      Queue<int[]> queue1 = new LinkedList<>();

      int max = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (matrix[i][j] == 0) {
            int count = 0;
            for (int f : favorites) {
              int[] fSeat = seats.get(f);
              if (fSeat != null && Math.abs(i - fSeat[0]) + Math.abs(j - fSeat[1]) == 1) {
                count++;
              }
            }

            if (count > max) {
              queue1.clear();
              queue1.add(new int[]{i, j});
              max = count;
            } else if (count == max) {
              queue1.add(new int[]{i, j});
            }
          }
        }
      }

      if (queue1.size() == 1) {
        int[] point = queue1.poll();
        matrix[point[0]][point[1]] = num;
        seats.put(num, point);
        continue;
      }

      Queue<int[]> queue2 = new LinkedList<>();
      max = 0;
      while (!queue1.isEmpty()) {
        int count = 0;
        int[] point = queue1.poll();
        for (int[] side : sides) {
          int x = point[0] + side[0];
          int y = point[1] + side[1];

          if (x >= 0 && x < N && y >= 0 && y < N && matrix[x][y] == 0) {
            count++;
          }
        }

        if (count > max) {
          queue2.clear();
          queue2.add(point);
          max = count;
        } else if (count == max) {
          queue2.add(point);
        }
      }

      if (!queue2.isEmpty()) {
        int[] point = queue2.poll();
        matrix[point[0]][point[1]] = num;
        seats.put(num, point);
      }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int[] favorites = map.get(matrix[i][j]);
        int count = 0;
        for (int f : favorites) {
          int[] fSeat = seats.get(f);
          if (fSeat != null && Math.abs(i - fSeat[0]) + Math.abs(j - fSeat[1]) == 1) {
            count++;
          }
        }
        if (count > 0) {
          answer += Math.pow(10, count - 1);
        }
      }
    }

    return answer;
  }
}