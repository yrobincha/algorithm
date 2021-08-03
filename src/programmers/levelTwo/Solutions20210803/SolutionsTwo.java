package programmers.levelTwo.Solutions20210803;

public class SolutionsTwo {

  public long solution(long w, long h) {
    long answer = 0;
    for (int i = 1; i < w; i++) {
      answer += (long) Math.floor((double) h * i / w);
    }
    return answer * 2;
  }
}