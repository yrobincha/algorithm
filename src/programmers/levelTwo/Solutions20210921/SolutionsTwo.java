package programmers.levelTwo.Solutions20210921;

public class SolutionsTwo {

  public int[] solution(int[] enter, int[] leave) {
    int[] eOrder = new int[enter.length];
    for (int i = 0; i < enter.length; i++) {
      eOrder[enter[i] - 1] = i;
    }

    int[] lOrder = new int[leave.length];
    for (int i = 0; i < leave.length; i++) {
      lOrder[leave[i] - 1] = i;
    }

    int[] answer = new int[leave.length];
    for (int i = 0; i < enter.length - 1; i++) {
      for (int j = i + 1; j < enter.length; j++) {
        if (eOrder[i] < eOrder[j] && lOrder[i] > lOrder[j]) {
          answer[i]++;
          answer[j]++;
        } else if (eOrder[i] > eOrder[j] && lOrder[i] < lOrder[j]) {
          answer[i]++;
          answer[j]++;
        } else if (eOrder[i] < eOrder[j] && lOrder[i] < lOrder[j]) {
          for (int k = eOrder[j] + 1; k < enter.length; k++) {
            int e = enter[k] - 1;
            if (lOrder[i] > lOrder[e]) {
              answer[i]++;
              answer[j]++;
              break;
            }
          }
        } else {
          for (int k = eOrder[i] + 1; k < enter.length; k++) {
            int e = enter[k] - 1;
            if (lOrder[j] > lOrder[e]) {
              answer[i]++;
              answer[j]++;
              break;
            }
          }
        }
      }
    }
    return answer;
  }
}