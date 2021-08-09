package programmers.levelTwo.Solutions20210809;

import java.util.HashMap;

public class SolutionsOne {

  HashMap<Integer, Boolean> primes = new HashMap<>();

  public int solution(String numbers) {
    permutation(numbers.toCharArray(), 0);
    return primes.size();
  }

  void permutation(char[] numbers, int index) {
    if (index == numbers.length) {
      for (int i = 1; i <= index; i++) {
        checkPrime(String.valueOf(numbers).substring(0, i));
      }
    } else {
      permutation(numbers, index + 1);
      for (int i = index + 1; i < numbers.length; i++) {
        swap(numbers, index, i);
        permutation(numbers, index + 1);
        swap(numbers, i, index);
      }
    }
  }

  void swap(char[] numbers, int pos1, int pos2) {
    char tmp = numbers[pos1];
    numbers[pos1] = numbers[pos2];
    numbers[pos2] = tmp;
  }

  void checkPrime(String numbers) {
    int num = Integer.parseInt(numbers);
    if (num < 2) {
      return;
    }
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return;
      }
    }
    primes.put(num, true);
  }
}