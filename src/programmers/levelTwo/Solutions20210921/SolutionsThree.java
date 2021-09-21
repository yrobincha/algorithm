package programmers.levelTwo.Solutions20210921;

import java.util.HashMap;

public class SolutionsThree {

  public int solution(String word) {
    HashMap<Character, Integer> cMap = new HashMap<>();
    char[] characters = new char[]{'A', 'E', 'I', 'O', 'U'};
    for (int i = 0; i < characters.length; i++) {
      cMap.put(characters[i], i);
    }
    int[] nums = new int[]{781, 156, 31, 6, 1};

    int answer = word.length();
    for (int i = 0; i < word.length(); i++) {
      answer += cMap.get(word.charAt(i)) * nums[i];
    }
    return answer;
  }
}