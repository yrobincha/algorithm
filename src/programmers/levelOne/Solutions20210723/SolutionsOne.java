package programmers.levelOne.Solutions20210723;

public class SolutionsOne {

  public int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    int[] clears = new int[N + 1];
    double[] fails = new double[N];

    for (int stage : stages) {
      clears[stage - 1] += 1;
    }

    int clearNumber = stages.length;
    for (int i = 0; i < N; i++) {
      if (clears[i] == 0) {
        fails[i] = 0.0;
      } else {
        fails[i] = clears[i] / (double) clearNumber;
      }

      answer[i] = i;
      clearNumber -= clears[i];
    }

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (fails[answer[i]] < fails[answer[j]]) {
          int tmp = answer[i];
          answer[i] = answer[j];
          answer[j] = tmp;
        } else if (fails[answer[i]] == fails[answer[j]] && answer[j] < answer[i]) {
          int tmp = answer[i];
          answer[i] = answer[j];
          answer[j] = tmp;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      answer[i] += 1;
    }
    return answer;
  }
}