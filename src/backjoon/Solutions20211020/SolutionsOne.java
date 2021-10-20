package backjoon.Solutions20211020;

import java.util.Scanner;

public class SolutionsOne {

  public static void main(String[] args) {
    SolutionsOne solution = new SolutionsOne();
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[][] lines = new int[N][3];
    for (int i = 0; i < N; i++) {
      int t = scanner.nextInt();
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      lines[i] = new int[]{t, x, y};
    }

    int[] nums = solution.solution(lines);
    System.out.println(nums[0] + "\n" + nums[1]);
  }

  int[] solution(int[][] lines) {
    int answer = 0;

    int[][] greenMap = new int[4][4];
    int[][] blueMap = new int[4][4];

    for (int[] line : lines) {
      int t = line[0];
      int x = line[1];
      int y = line[2];
      int[][] greenShift = new int[2][4];
      int[][] blueShift = new int[4][2];

      makeGreen(greenMap, greenShift, t, y);
      makeBlue(blueMap, blueShift, t, x);

      answer += checkGreenMap(greenMap);
      shiftGreenMap(greenMap, greenShift);

      answer += checkBlueMap(blueMap);
      shiftBlueMap(blueMap, blueShift);
    }

    int block = 0;
    for (int i = 0; i < greenMap.length; i++) {
      for (int j = 0; j < greenMap[i].length; j++) {
        block += greenMap[i][j] + blueMap[i][j];
      }
    }

    return new int[]{answer, block};
  }

  void makeGreen(int[][] map, int[][] shift, int t, int y) {
    if (t == 1) {
      int target = map.length - 1;
      for (int i = 0; i < map.length; i++) {
        if (map[i][y] == 1) {
          target = i - 1;
          break;
        }
      }
      if (target < 0) {
        shift[shift.length - 1][y] = 1;
      } else {
        map[target][y] = 1;
      }
    } else if (t == 2) {
      int target = map.length - 1;
      for (int i = 0; i < map.length; i++) {
        if (map[i][y] == 1 || map[i][y + 1] == 1) {
          target = i - 1;
          break;
        }
      }
      if (target < 0) {
        shift[shift.length - 1][y] = 1;
        shift[shift.length - 1][y + 1] = 1;
      } else {
        map[target][y] = 1;
        map[target][y + 1] = 1;
      }
    } else if (t == 3) {
      int target = map.length - 1;
      for (int i = 0; i < map.length; i++) {
        if (map[i][y] == 1) {
          target = i - 1;
          break;
        }
      }
      if (target < 0) {
        shift[shift.length - 1][y] = 1;
        shift[shift.length - 2][y] = 1;
      } else if (target == 0) {
        shift[shift.length - 1][y] = 1;
        map[target][y] = 1;
      } else {
        map[target - 1][y] = 1;
        map[target][y] = 1;
      }
    }
  }

  void makeBlue(int[][] map, int[][] shift, int t, int x) {
    if (t == 1) {
      int target = map.length - 1;
      for (int j = 0; j < map.length; j++) {
        if (map[x][j] == 1) {
          target = j - 1;
          break;
        }
      }
      if (target < 0) {
        shift[x][shift[0].length - 1] = 1;
      } else {
        map[x][target] = 1;
      }
    } else if (t == 2) {
      int target = map.length - 1;
      for (int j = 0; j < map.length; j++) {
        if (map[x][j] == 1) {
          target = j - 1;
          break;
        }
      }
      if (target < 0) {
        shift[x][shift[0].length - 1] = 1;
        shift[x][shift[0].length - 2] = 1;
      } else if (target == 0) {
        shift[x][shift[0].length - 1] = 1;
        map[x][target] = 1;
      } else {
        map[x][target - 1] = 1;
        map[x][target] = 1;
      }
    } else if (t == 3) {
      int target = map.length - 1;
      for (int j = 0; j < map.length; j++) {
        if (map[x][j] == 1 || map[x + 1][j] == 1) {
          target = j - 1;
          break;
        }
      }
      if (target < 0) {
        shift[x][shift[0].length - 1] = 1;
        shift[x + 1][shift[0].length - 1] = 1;
      } else {
        map[x][target] = 1;
        map[x + 1][target] = 1;
      }
    }
  }

  int checkGreenMap(int[][] map) {
    int score = 0;
    int[] blocks = new int[map.length];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        blocks[i] += map[i][j];
      }
      if (blocks[i] == 4) {
        map[i] = new int[map[i].length];
        score++;
        blocks[i] = 0;
      }
    }
    if (score == 0) {
      return 0;
    }

    int index = map.length - 1;
    for (int i = map.length - 1; i >= 0; i--) {
      if (blocks[i] > 0) {
        map[index--] = map[i];
      }
    }

    for (; index >= 0; index--) {
      map[index] = new int[map.length];
    }
    return score;
  }

  int checkBlueMap(int[][] map) {
    int score = 0;
    int[] blocks = new int[map.length];
    for (int j = 0; j < map[0].length; j++) {
      for (int[] m : map) {
        blocks[j] += m[j];
      }
      if (blocks[j] == 4) {
        for (int i = 0; i < map.length; i++) {
          map[i][j] = 0;
        }
        score++;
        blocks[j] = 0;
      }
    }
    if (score == 0) {
      return 0;
    }

    int index = map.length - 1;
    for (int j = map.length - 1; j >= 0; j--) {
      if (blocks[j] > 0) {
        for (int i = 0; i < map.length; i++) {
          map[i][index] = map[i][j];
        }
        index--;
      }
    }

    for (; index >= 0; index--) {
      for (int i = 0; i < map.length; i++) {
        map[i][index] = 0;
      }
    }
    return score;
  }

  void shiftGreenMap(int[][] map, int[][] shift) {
    int size = 0;
    for (int[] s : shift) {
      for (int i : s) {
        if (i == 1) {
          size++;
          break;
        }
      }
    }
    if (size == 0) {
      return;
    } else if (size == 1) {
      int sum = 0;
      for (int j = 0; j < map[0].length; j++) {
        sum += map[0][j];
      }

      if (sum == 0) {
        map[0] = shift[1];
        return;
      }
    }

    for (int i = map.length - 1; i - size >= 0; i--) {
      System.arraycopy(map[i - size], 0, map[i], 0, map[i].length);
    }

    int index = size - 1;
    for (int i = shift.length - 1; i >= shift.length - size; i--) {
      System.arraycopy(shift[i], 0, map[index], 0, shift[i].length);
      index--;
    }
  }

  void shiftBlueMap(int[][] map, int[][] shift) {
    int size = 0;
    for (int j = 0; j < shift[0].length; j++) {
      for (int[] s : shift) {
        if (s[j] == 1) {
          size++;
          break;
        }
      }
    }
    if (size == 0) {
      return;
    } else if (size == 1) {
      int sum = 0;
      for (int[] m : map) {
        sum += m[0];
      }

      if (sum == 0) {
        for (int i = 0; i < map.length; i++) {
          map[i][0] = shift[i][1];
        }
        return;
      }
    }

    for (int j = map.length - 1; j - size >= 0; j--) {
      for (int i = 0; i < map.length; i++) {
        map[i][j] = map[i][j - size];
      }
    }

    int index = size - 1;
    for (int j = shift[0].length - 1; j >= shift[0].length - size; j--) {
      for (int i = 0; i < shift.length; i++) {
        map[i][index] = shift[i][j];
      }
      index--;
    }
  }
}