package programmers.levelOne.Solutions20210722;

public class SolutionsTwo {

  public int solution(int n) {
    int answer = 0;
    StringBuilder tris = new StringBuilder();
    while (n >= 3) {
      tris.append(n % 3);
      n = n / 3;
    }
    tris.append(n);
    tris.reverse();
    for (int i = 0; i < tris.length(); i++) {
      answer += (tris.charAt(i) - '0') * Math.pow(3, i);
    }
    return answer;
  }
}