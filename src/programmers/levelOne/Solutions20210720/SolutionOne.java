package programmers.levelOne.Solutions20210720;

import java.util.ArrayList;

public class SolutionOne {

  public int[] solution(int[] answers) {
    int[] answer;
    int max;
    ArrayList<Integer> maths = new ArrayList<>();

    int one = count(new int[]{1, 2, 3, 4, 5}, answers);
    maths.add(1);
    max = one;

    int two = count(new int[]{2, 1, 2, 3, 2, 4, 2, 5}, answers);
    if (max < two) {
      maths.clear();
      maths.add(2);
      max = two;
    } else if (max == two) {
      maths.add(2);
    }
    int three = count(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, answers);
    if (max < three) {
      maths.clear();
      maths.add(3);
    } else if (max == three) {
      maths.add(3);
    }

    answer = new int[maths.size()];
    for (int i = 0; i < maths.size(); i++) {
      answer[i] = maths.get(i);
    }
    return answer;
  }

  int count(int[] maths, int[] answers) {
    int count = 0;
    int index = 0;

    for (int answer : answers) {
      if (maths[index++] == answer) {
        count++;
      }

      if (index == maths.length) {
        index = 0;
      }
    }
    return count;
  }
}
