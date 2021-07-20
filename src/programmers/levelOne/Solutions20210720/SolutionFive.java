package programmers.levelOne.Solutions20210720;

public class SolutionFive {

  public String solution(int[] numbers, String hand) {
    StringBuilder answer = new StringBuilder();
    int left = -1;
    int right = -2;
    for (int number : numbers) {
      if (number == 1 || number == 4 || number == 7) {
        answer.append("L");
        left = number;
      } else if (number == 3 || number == 6 || number == 9) {
        answer.append("R");
        right = number;
      } else {
        int[] target = getPosition(number);
        int[] leftPosition = getPosition(left);
        int[] rightPosition = getPosition(right);

        if (getDistance(target, leftPosition) > getDistance(target, rightPosition)) {
          answer.append("R");
          right = number;
        } else if (getDistance(target, leftPosition) == getDistance(target, rightPosition)) {
          if (hand.equals("left")) {
            answer.append("L");
            left = number;
          } else if (hand.equals("right")) {
            answer.append("R");
            right = number;
          }
        } else {
          answer.append("L");
          left = number;
        }
      }
    }
    return answer.toString();
  }

  int[] getPosition(int number) {
    if (number == -2) {
      return new int[]{3, 2};
    } else if (number == -1) {
      return new int[]{3, 0};
    } else if (number == 0) {
      return new int[]{3, 1};
    } else if (number % 3 == 0) {
      return new int[]{number / 3 - 1, 2};
    } else {
      return new int[]{number / 3, number % 3 - 1};
    }
  }

  int getDistance(int[] target, int[] current) {
    int x = Math.abs(Math.abs(target[0]) - Math.abs(current[0]));
    int y = Math.abs(Math.abs(target[1]) - Math.abs(current[1]));
    return x + y;
  }
}