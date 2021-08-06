package programmers.levelTwo.Solutions20210806;

import java.util.ArrayList;

public class SolutionsTwo {

  public int[] solution(String[][] places) {
    int[] answer = new int[places.length];
    ArrayList<Pair> positions = new ArrayList<>();
    for (int i = 0; i < places.length; i++) {
      for (int j = 0; j < places[i].length; j++) {
        String s = places[i][j];
        for (int k = 0; k < places[i][j].length(); k++) {
          if (s.charAt(k) == 'P') {
            positions.add(new Pair(j, k));
          }
        }
      }

      int check = 1;
      for (int j = 0; j < positions.size() - 1; j++) {
        Pair p1 = positions.get(j);
        for (int k = j + 1; k < positions.size(); k++) {
          Pair p2 = positions.get(k);
          int distance = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
          if (distance == 1) {
            check = 0;
            break;
          } else if (distance == 2) {
            if (p1.x == p2.x) {
              int index = Math.min(p1.y, p2.y) + 1;
              if (places[i][p1.x].charAt(index) != 'X') {
                check = 0;
                break;
              }
            } else if (p1.y == p2.y) {
              int index = Math.min(p1.x, p2.x) + 1;
              if (places[i][index].charAt(p1.y) != 'X') {
                check = 0;
                break;
              }
            } else {
              if (places[i][p2.x].charAt(p1.y) != 'X' || places[i][p1.x].charAt(p2.y) != 'X') {
                check = 0;
                break;
              }
            }
          }
        }
        if (check == 0) {
          break;
        }
      }
      answer[i] = check;
      positions.clear();
    }
    return answer;
  }
}

class Pair {

  int x, y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}