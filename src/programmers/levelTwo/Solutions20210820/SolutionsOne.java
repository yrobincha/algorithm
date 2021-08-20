package programmers.levelTwo.Solutions20210820;

import java.util.ArrayList;

public class SolutionsOne {

  public int solution(int m, int n, String[] board) {
    int answer = 0;
    char[][] friends = new char[m][n];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length(); j++) {
        friends[i][j] = board[i].charAt(j);
      }
    }

    while (true) {
      ArrayList<Pair> pops = new ArrayList<>();
      for (int x = 0; x < board.length - 1; x++) {
        for (int y = 0; y < board[x].length() - 1; y++) {
          if (friends[x][y] != '0' && checkFriend(x, y, friends)) {
            pops.add(new Pair(x, y));
            pops.add(new Pair(x, y + 1));
            pops.add(new Pair(x + 1, y));
            pops.add(new Pair(x + 1, y + 1));
          }
        }
      }

      if (pops.isEmpty()) {
        break;
      } else {
        for (Pair p : pops) {
          if (friends[p.x][p.y] != '0') {
            friends[p.x][p.y] = '0';
            answer++;
          }
        }
      }

      for (int y = 0; y < n; y++) {
        for (int x = m - 1; x > 0; x--) {
          if (friends[x][y] == '0') {
            for (int i = x - 1; i >= 0; i--) {
              if (friends[i][y] != '0') {
                friends[x][y] = friends[i][y];
                friends[i][y] = '0';
                break;
              }
            }
          }
        }
      }
    }
    return answer;
  }

  boolean checkFriend(int x, int y, char[][] friends) {
    if (x + 1 >= friends.length || y + 1 >= friends[0].length) {
      return false;
    }
    char c = friends[x][y];
    return c == friends[x][y + 1] && c == friends[x + 1][y] && c == friends[x + 1][y + 1];
  }
}

class Pair {

  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}