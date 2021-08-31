package programmers.levelThree.Solutions20210831;

import java.util.Arrays;

public class SolutionsTwo {

  public long solution(int n, int[] times) {
    long answer = 0;
    Arrays.sort(times);

    long low = 0;
    long high = (long) times[times.length - 1] * n;

    while (low <= high) {
      long mid = (low + high) / 2;
      long count = 0;
      boolean check = false;
      for (int time : times) {
        count += mid / time;
        check = check || mid % time == 0;
      }
      if (count >= n) {
        if (answer == 0) {
          answer = mid;
        } else {
          answer = Math.min(answer, mid);
        }
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return answer;
  }
}