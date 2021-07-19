package programmers.levelOne.Solutions20210719;

public class SolutionTwo {

  public int solution(int[] nums) {
    int answer = 0;

    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (checkPrime(nums[i] + nums[j] + nums[k])) {
            answer++;
          }
        }
      }
    }

    return answer;
  }

  boolean checkPrime(int num) {
    for (int i = 2; i < num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}