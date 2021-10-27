package programmers.levelTwo.Solutions20211027;

public class SolutionsThree {

  public int[] solution(int n, long left, long right) {

    int start = (int) (left / n);
    int startRemain = (int) (left % n);
    int end = (int) Math.ceil(right / (double) n);
    int endRemain = (int) (right % n);
    int[][] matrix = new int[end - start][n];

    for (int i = start; i < end; i++) {
      int index = 0;
      while (index < n) {
        if (index < i + 1) {
          matrix[i - start][index++] = i + 1;
        } else {
          matrix[i - start][index] = index++ + 1;
        }
      }
    }

    int index = 0;
    int[] answer = new int[(int) (right - left) + 1];

    for (int j = startRemain; j < n && index < answer.length; j++) {
      answer[index++] = matrix[0][j];
    }

    for (int i = 1; i < matrix.length - 1 && index < answer.length; i++) {
      for (int j = 0; j < n && index < answer.length; j++) {
        answer[index++] = matrix[i][j];
      }
    }

    for (int j = 0; j <= endRemain && index < answer.length; j++) {
      answer[index++] = matrix[matrix.length - 1][j];
    }
    return answer;
  }
}