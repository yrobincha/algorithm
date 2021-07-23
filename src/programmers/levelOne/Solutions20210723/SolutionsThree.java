package programmers.levelOne.Solutions20210723;

public class SolutionsThree {

  public String solution(int a, int b) {
    String[] answerSet = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int[] months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int days = b;
    for (int i = 0; i < a - 1; i++) {
      days += months[i];
    }
    return answerSet[(days % 7 + 4) % 7];
  }
}