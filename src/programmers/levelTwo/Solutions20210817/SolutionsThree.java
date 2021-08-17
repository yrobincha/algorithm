package programmers.levelTwo.Solutions20210817;

import java.util.ArrayList;

public class SolutionsThree {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    ArrayList<Pair> queue = new ArrayList<>();
    for (int truck : truck_weights) {
      queue.add(new Pair(truck, 0));
    }

    int current = 0;
    int count = 0;
    while (!queue.isEmpty()) {
      answer++;
      for (Pair truck : queue) {
        if (truck.time > 0) {
          truck.time += 1;
        }
      }

      Pair truck = queue.get(0);
      if (truck.time == bridge_length + 1) {
        queue.remove(0);
        current -= truck.weight;
        count--;
      }

      if (count < queue.size()) {
        Pair plus = queue.get(count);
        if (current + plus.weight <= weight) {
          current += plus.weight;
          plus.time = 1;
          count++;
        }
      }
    }
    return answer;
  }
}

class Pair {

  int weight;
  int time;

  public Pair(int weight, int time) {
    this.weight = weight;
    this.time = time;
  }
}