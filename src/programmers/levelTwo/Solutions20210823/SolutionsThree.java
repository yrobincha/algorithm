package programmers.levelTwo.Solutions20210823;

import java.util.HashMap;

public class SolutionsThree {

  public int[] solution(int n, String[] words) {
    int[] answer = new int[]{0, 0};
    HashMap<String, Integer> wordMap = new HashMap<>();
    String pre = words[0];
    wordMap.put(pre, 1);
    for (int i = 1; i < words.length; i++) {
      String word = words[i];
      if (pre.charAt(pre.length() - 1) != word.charAt(0)) {
        answer[0] = i % n + 1;
        answer[1] = i / n + 1;
        break;
      } else if (wordMap.containsKey(word)) {
        answer[0] = i % n + 1;
        answer[1] = i / n + 1;
        break;
      } else {
        wordMap.put(word, 1);
        pre = word;
      }
    }
    return answer;
  }
}