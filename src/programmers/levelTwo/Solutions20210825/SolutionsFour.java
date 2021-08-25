package programmers.levelTwo.Solutions20210825;

public class SolutionsFour {

  public int[] solution(int[][] arr) {
    return search(0, 0, arr.length, arr.length, arr);
  }

  int[] search(int x1, int y1, int x2, int y2, int[][] arr) {
    int unit = x2 - x1;
    int[] s = new int[]{0, 0};

    for (int i = x1; i < x2; i++) {
      for (int j = y1; j < y2; j++) {
        s[arr[i][j]]++;
      }
    }

    if (check(s, unit) || unit == 2) {
      return s;
    }

    s = new int[]{0, 0};
    for (int i = x1; i < x2; i += unit / 2) {
      for (int j = y1; j < y2; j += unit / 2) {
        int[] result = search(i, j, i + unit / 2, j + unit / 2, arr);
        s[0] += result[0];
        s[1] += result[1];
      }
    }

    if (s[0] == 4 && s[1] == 0) {
      s[0] = 1;
    } else if (s[0] == 0 && s[1] == 4) {
      s[1] = 1;
    }
    return s;
  }

  boolean check(int[] s, int unit) {
    for (int i = 0; i < s.length; i++) {
      if (s[i] == unit * unit) {
        s[i] = 1;
        return true;
      }
    }
    return false;
  }
}