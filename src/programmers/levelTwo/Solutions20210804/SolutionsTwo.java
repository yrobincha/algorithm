package programmers.levelTwo.Solutions20210804;

public class SolutionsTwo {

  int answer = 0;
  int[] numbers;
  int target;

  public int solution(int[] numbers, int target) {
    this.numbers = numbers;
    this.target = target;
    calculate(numbers[0], numbers[1], true, 1);
    calculate(numbers[0] * -1, numbers[1], true, 1);
    calculate(numbers[0], numbers[1], false, 1);
    calculate(numbers[0] * -1, numbers[1], false, 1);
    return answer;
  }

  void calculate(int num1, int num2, boolean isPlus, int depth) {
    int value = isPlus ? num1 + num2 : num1 - num2;
    if (depth == numbers.length - 1 && value == target) {
      answer++;
    } else if (depth < numbers.length - 1) {
      calculate(value, numbers[depth + 1], true, depth + 1);
      calculate(value, numbers[depth + 1], false, depth + 1);
    }
  }
}