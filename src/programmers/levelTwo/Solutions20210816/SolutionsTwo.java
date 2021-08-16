package programmers.levelTwo.Solutions20210816;

public class SolutionsTwo {

  public int solution(String name) {
    int upDown = 0;
    int leftRight = name.length() - 1;
    for (int i = 0; i < name.length(); i++) {
      char c = name.charAt(i);
      int up = c - 'A';
      int down = 'Z' - c + 1;
      upDown += Math.min(up, down);

      int next = i + 1;
      while (next < name.length() && name.charAt(next) == 'A') {
        next++;
      }
      leftRight = Math.min(leftRight, (i * 2) + name.length() - next);
    }
    return upDown + leftRight;
  }
}