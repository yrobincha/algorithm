package programmers.levelTwo.Solutions20210803;

import java.util.PriorityQueue;

public class SolutionsOne {

  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> scovilles = new PriorityQueue<>();
    for (int s : scoville) {
      scovilles.add(s);
    }

    while (scovilles.size() > 1 && scovilles.peek() < K) {
      scovilles.add(scovilles.remove() + scovilles.remove() * 2);
      answer++;
    }

    if (scovilles.peek() != null && scovilles.peek() >= K) {
      return answer;
    } else {
      return -1;
    }
  }
}