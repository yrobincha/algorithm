package programmers.levelTwo.Solutions20210804;

import java.util.ArrayList;
import java.util.HashMap;

public class SolutionsThree {

  public String[] solution(String[] record) {
    HashMap<String, String> users = new HashMap<>();
    ArrayList<String> records = new ArrayList<>();
    for (String r : record) {
      String[] strings = r.split(" ");
      switch (strings[0]) {
        case "Enter" -> {
          users.put(strings[1], strings[2]);
          records.add(strings[1] + "님이 들어왔습니다.");
        }
        case "Leave" -> records.add(strings[1] + "님이 나갔습니다.");
        case "Change" -> users.put(strings[1], strings[2]);
      }
    }

    String[] answer = new String[records.size()];
    for (int i = 0; i < records.size(); i++) {
      String uid = records.get(i).split("님")[0];
      answer[i] = records.get(i).replaceAll(uid, users.get(uid));
    }
    return answer;
  }
}