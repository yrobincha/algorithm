package backjoon.Solutions20211023;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionsThree {

  public static void main(String[] args) {
    SolutionsThree solution = new SolutionsThree();
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int K = scanner.nextInt();
    int[] matrix = new int[N * 2];
    for (int i = 0; i < matrix.length; i++) {
      matrix[i] = scanner.nextInt();
    }

    System.out.println(solution.solution(N, K, matrix));
  }

  int solution(int N, int K, int[] matrix) {
    int time = 0;
    ArrayList<Box> belt = new ArrayList<>();
    for (int m : matrix) {
      belt.add(new Box(m));
    }

    while (check(K, belt)) {
      time++;
      Box box = belt.remove(belt.size() - 1);
      belt.add(0, box);
      belt.get(N - 1).hasRobot = false;

      for (int i = N - 2; i >= 1; i--) {
        Box current = belt.get(i);
        Box next = belt.get(i + 1);
        if (current.hasRobot && !next.hasRobot && next.weight > 0) {
          next.hasRobot = true;
          next.weight--;
          current.hasRobot = false;
        }
      }
      belt.get(N - 1).hasRobot = false;

      if (belt.get(0).weight > 0) {
        belt.get(0).weight--;
        belt.get(0).hasRobot = true;
      }
    }
    return time;
  }

  boolean check(int K, ArrayList<Box> belt) {
    int sum = 0;
    for (Box box : belt) {
      if (box.weight == 0) {
        sum++;
      }
    }

    return sum < K;
  }
}

class Box {

  boolean hasRobot;
  int weight;

  public Box(int weight) {
    this.weight = weight;
  }
}