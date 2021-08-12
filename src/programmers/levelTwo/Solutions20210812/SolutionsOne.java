package programmers.levelTwo.Solutions20210812;

public class SolutionsOne {

  public int[] solution(int rows, int columns, int[][] queries) {
    int[] answer = new int[queries.length];
    int[][] matrix = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = i * columns + j + 1;
      }
    }

    for (int i = 0; i < queries.length; i++) {
      int[] query = queries[i];
      int j = query[0] - 1;
      int k = query[1] - 1;
      int min = matrix[j][k];
      boolean loop = false;
      while (j >= query[0] - 1 && j <= query[2] - 1 && k >= query[1] - 1 && k <= query[3] - 1) {
        int tmp = matrix[j][k];
        int tJ = j;
        int tK = k;

        if (j == query[0] - 1) {
          if (k == query[1] - 1 && !loop) {
            loop = true;
            j++;
          } else {
            k--;
          }
        } else if (j == query[2] - 1) {
          if (k == query[3] - 1) {
            j--;
          } else {
            k++;
          }
        } else if (k == query[1] - 1) {
          j++;
        } else if (k == query[3] - 1) {
          j--;
        }

        if (j > query[0] - 1 || k > query[1] - 1) {
          if (matrix[j][k] < min) {
            min = matrix[j][k];
          }
          matrix[tJ][tK] = matrix[j][k];
          matrix[j][k] = tmp;
        }
      }
      answer[i] = min;
    }
    return answer;
  }
}