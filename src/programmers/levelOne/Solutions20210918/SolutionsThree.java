package programmers.levelOne.Solutions20210918;

public class SolutionsThree {

  public String solution(int[][] scores) {
    StringBuilder answer = new StringBuilder();
    for (int j = 0; j < scores[0].length; j++) {
      int sum = 0;
      int small = 0;
      int big = 0;
      int standard = scores[j][j];
      for (int[] score : scores) {
        sum += score[j];
        if (score[j] > standard) {
          big++;
        } else if (score[j] < standard) {
          small++;
        }
      }
      if (small == scores.length - 1 || big == scores.length - 1) {
        answer.append(getScore(((double) sum - standard) / (scores.length - 1)));
      } else {
        answer.append(getScore((double) sum / scores.length));
      }
    }
    return answer.toString();
  }

  String getScore(double score) {
    if (score >= 90) {
      return "A";
    } else if (score >= 80) {
      return "B";
    } else if (score >= 70) {
      return "C";
    } else if (score >= 50) {
      return "D";
    } else {
      return "F";
    }
  }
}