package programmers.levelTwo.Solutions20211027;

public class SolutionsOne {

  int max = 0;

  public int solution(int k, int[][] dungeons) {
    permutation(dungeons, 0, k);
    return max;
  }

  void permutation(int[][] dungeons, int index, int k) {
    if (index == dungeons.length) {
      int value = k;
      int count = 0;
      for (int[] dungeon : dungeons) {
        if (value >= dungeon[0]) {
          value -= dungeon[1];
          count++;
        } else {
          break;
        }
      }
      max = Math.max(max, count);
    } else {
      permutation(dungeons, index + 1, k);
      for (int i = index + 1; i < dungeons.length; i++) {
        swap(dungeons, i, index);
        permutation(dungeons, index + 1, k);
        swap(dungeons, index, i);
      }
    }
  }

  void swap(int[][] dungeons, int pos1, int pos2) {
    int[] tmp = dungeons[pos1];
    dungeons[pos1] = dungeons[pos2];
    dungeons[pos2] = tmp;
  }
}