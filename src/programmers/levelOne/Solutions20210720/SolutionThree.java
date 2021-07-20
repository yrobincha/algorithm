package programmers.levelOne.Solutions20210720;

public class SolutionThree {

  public int solution(int n, int[] lost, int[] reserve) {
    int count = n;

    for (int i = 0; i < reserve.length; i++) {
      for (int j = 0; j < lost.length; j++) {
        if (lost[j] == reserve[i]) {
          lost[j] = -1;
          reserve[i] = -1;
          break;
        }
      }
    }

    for (int i = 0; i < reserve.length; i++) {
      for (int j = 0; j < lost.length; j++) {
        if (lost[j] == reserve[i] - 1 || lost[j] == reserve[i] + 1) {
          lost[j] = -1;
          reserve[i] = -1;
          break;
        }
      }
    }

    for (int c : lost) {
      if (c > 0) {
        count--;
      }
    }
    return count;
  }
}