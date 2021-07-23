package programmers.levelOne.Solutions20210723;

public class SolutionsFour {

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      int number = arr1[i] | arr2[i];
      StringBuilder row = new StringBuilder();
      while (number > 0) {
        if (number % 2 == 0) {
          row.append(" ");
        } else {
          row.append("#");
        }
        number /= 2;
      }

      while (row.length() < n) {
        row.append(" ");
      }
      answer[i] = row.reverse().toString();
    }
    return answer;
  }
}