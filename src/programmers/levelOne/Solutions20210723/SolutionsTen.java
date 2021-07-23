package programmers.levelOne.Solutions20210723;

public class SolutionsTen {

  public String[] solution(String[] strings, int n) {
    for (int i = 0; i < strings.length - 1; i++) {
      for (int j = i; j < strings.length; j++) {
        if (strings[i].charAt(n) > strings[j].charAt(n)) {
          String tmp = strings[j];
          strings[j] = strings[i];
          strings[i] = tmp;
        } else if (strings[i].charAt(n) == strings[j].charAt(n)) {
          if (strings[i].compareTo(strings[j]) > 0) {
            String tmp = strings[j];
            strings[j] = strings[i];
            strings[i] = tmp;
          }
        }
      }
    }
    return strings;
  }
}