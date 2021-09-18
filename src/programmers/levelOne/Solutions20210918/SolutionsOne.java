package programmers.levelOne.Solutions20210918;

import java.util.Arrays;

public class SolutionsOne {

  public int[] solution(int[] weights, String[] head2head) {
    Player[] players = new Player[weights.length];
    for (int i = 0; i < head2head.length; i++) {
      double game = 0;
      double win = 0;
      int winHeavy = 0;
      String head = head2head[i];
      for (int j = 0; j < head.length(); j++) {
        if (head.charAt(j) == 'L') {
          game++;
        } else if (head.charAt(j) == 'W') {
          game++;
          win++;
          if (weights[j] > weights[i]) {
            winHeavy++;
          }
        }
      }
      players[i] = new Player(i + 1, weights[i], game == 0 ? 0 : win / game, winHeavy);
    }

    Arrays.sort(players, (o1, o2) -> {
      if (o1.rate > o2.rate) {
        return -1;
      } else if (o1.rate == o2.rate) {
        if (o1.winHeavy > o2.winHeavy) {
          return -1;
        } else if (o1.winHeavy == o2.winHeavy) {
          return o2.weight - o1.weight;
        } else {
          return 1;
        }
      } else {
        return 1;
      }
    });

    int[] answer = new int[players.length];
    for (int i = 0; i < players.length; i++) {
      answer[i] = players[i].number;
    }

    return answer;
  }
}

class Player {

  int number;
  int weight;
  double rate;
  int winHeavy;

  public Player(int number, int weight, double rate, int winHeavy) {
    this.number = number;
    this.weight = weight;
    this.rate = rate;
    this.winHeavy = winHeavy;
  }
}