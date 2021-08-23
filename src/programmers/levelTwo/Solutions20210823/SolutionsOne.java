package programmers.levelTwo.Solutions20210823;

public class SolutionsOne {

  public long[] solution(long[] numbers) {
    long[] answer = new long[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] % 2 == 0) {
        answer[i] = numbers[i] + 1;
      } else {
        StringBuilder builder = new StringBuilder(makeString(numbers[i]));
        int index = 0;
        for (int j = builder.length() - 1; j >= 0; j--) {
          if (builder.charAt(j) == '0') {
            builder.setCharAt(j, '1');
            index = j;
            break;
          }
        }

        for (int j = index + 1; j < builder.length(); j++) {
          if (builder.charAt(j) == '1') {
            builder.setCharAt(j, '0');
            break;
          }
        }
        answer[i] = Long.parseLong(builder.toString(), 2);
      }
    }
    return answer;
  }

  String makeString(long num) {
    return "0" + Long.toBinaryString(num);
  }
}