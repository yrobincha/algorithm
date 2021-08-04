package programmers.levelTwo.Solutions20210804;

public class SolutionsOne {

  char[] characters = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
  String[] data;
  int n;
  int answer = 0;

  public int solution(int n, String[] data) {
    this.data = data;
    this.n = n;
    permutation(new StringBuffer(String.valueOf(characters)), 0);
    return answer;
  }

  void permutation(StringBuffer s, int index) {
    if (index == s.length()) {
      if (checkCondition(s.toString())) {
        answer++;
      }
    } else {
      permutation(s, index + 1);
      for (int i = index + 1; i < s.length(); i++) {
        swap(s, index, i);
        permutation(s, index + 1);
        swap(s, i, index);
      }
    }
  }

  void swap(StringBuffer s, int pos1, int pos2) {
    char tmp = s.charAt(pos1);
    s.setCharAt(pos1, s.charAt(pos2));
    s.setCharAt(pos2, tmp);
  }

  boolean checkCondition(String s) {
    for (String data : data) {
      char c1 = data.charAt(0);
      char c2 = data.charAt(2);
      int gap = Math.abs(s.indexOf(c1) - s.indexOf(c2)) - 1;
      if (data.charAt(3) == '>' && gap <= data.charAt(4) - '0') {
        return false;
      } else if (data.charAt(3) == '=' && gap != data.charAt(4) - '0') {
        return false;
      } else if (data.charAt(3) == '<' && gap >= data.charAt(4) - '0') {
        return false;
      }
    }
    return true;
  }
}