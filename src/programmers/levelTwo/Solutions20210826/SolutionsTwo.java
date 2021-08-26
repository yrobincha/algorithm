package programmers.levelTwo.Solutions20210826;

import java.util.ArrayList;
import java.util.HashMap;

public class SolutionsTwo {

  public int[] solution(String msg) {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<String, Integer> dMap = new HashMap<>();
    char c = 'A';
    for (int i = 0; i <= 'Z' - 'A'; i++) {
      dMap.put((char) (c + i) + "", i + 1);
    }

    for (int i = 0; i < msg.length(); i++) {
      StringBuilder builder = new StringBuilder(msg.charAt(i) + "");
      for (int j = i + 1; j < msg.length(); j++) {
        builder.append(msg.charAt(j));
        if (dMap.get(builder.toString()) == null) {
          dMap.put(builder.toString(), dMap.size() + 1);
          builder.replace(builder.length() - 1, builder.length(), "");
          break;
        }
      }
      i = i + builder.length() - 1;
      list.add(dMap.get(builder.toString()));
    }

    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }
}