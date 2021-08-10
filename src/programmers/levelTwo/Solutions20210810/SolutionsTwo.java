package programmers.levelTwo.Solutions20210810;

import java.util.Arrays;
import java.util.HashMap;

class SolutionsTwo {

  public boolean solution(String[] phone_book) {
    Arrays.sort(phone_book, (o1, o2) -> o2.length() - o1.length());

    HashMap<String, String> hm = new HashMap<>();
    for (String str : phone_book) {
      if (hm.get(str) != null) {
        return false;
      }
      for (int i = 1; i <= str.length(); i++) {
        hm.put(str.substring(0, i), "");
      }
    }
    return true;
  }
}