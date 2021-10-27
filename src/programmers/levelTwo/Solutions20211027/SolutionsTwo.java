package programmers.levelTwo.Solutions20211027;

import java.util.Arrays;
import java.util.HashSet;

public class SolutionsTwo {

  public String[] solution(int[][] line) {
    HashSet<int[]> set = new HashSet<>();
    int maxX = Integer.MAX_VALUE * -1;
    int minX = Integer.MAX_VALUE;
    int maxY = Integer.MAX_VALUE * -1;
    int minY = Integer.MAX_VALUE;

    for (int i = 0; i < line.length - 1; i++) {
      int a = line[i][0];
      int b = line[i][1];
      int e = line[i][2];
      for (int j = i + 1; j < line.length; j++) {
        int c = line[j][0];
        int d = line[j][1];
        int f = line[j][2];

        long ad = (long) a * d;
        long bc = (long) b * c;
        if (ad - bc != 0) {
          long x = (long) b * f - (long) e * d;
          long y = (long) e * c - (long) a * f;

          if (x % (ad - bc) != 0 || y % (ad - bc) != 0) {
            continue;
          }

          int tx = (int) (x / (ad - bc));
          int ty = (int) (y / (ad - bc));
          set.add(new int[]{tx, ty});

          if (tx > maxX) {
            maxX = tx;
          }
          if (tx < minX) {
            minX = tx;
          }

          if (ty > maxY) {
            maxY = ty;
          }
          if (ty < minY) {
            minY = ty;
          }
        }
      }
    }

    int xGap = -minX;
    minX += xGap;
    maxX += xGap;

    int yGap = -minY;
    minY += yGap;
    maxY += yGap;

    String[] answer = new String[maxY - minY + 1];
    Arrays.fill(answer, ".".repeat(Math.max(0, maxX - minX + 1)));

    for (int[] point : set) {
      int x = point[0] + xGap;
      int y = answer.length - (point[1] + yGap) - 1;
      StringBuilder builder = new StringBuilder(answer[y]);
      builder.setCharAt(x, '*');
      answer[y] = builder.toString();
    }
    return answer;
  }
}