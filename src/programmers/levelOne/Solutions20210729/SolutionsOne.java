package programmers.levelOne.Solutions20210729;

public class SolutionsOne {

  public int[] solution(int[] arr) {
    int[] answer;
    if (arr.length <= 1) {
      answer = new int[]{-1};
    } else {
      int minIndex = 0;
      for (int i = 1; i < arr.length; i++) {
        if (arr[minIndex] > arr[i]) {
          minIndex = i;
        }
      }
      answer = new int[arr.length - 1];
      int index = 0;
      for (int i = 0; i < arr.length; i++) {
        if (i != minIndex) {
          answer[index++] = arr[i];
        }
      }
    }
    return answer;
  }
}