package programmers.levelThree.Solutions20210902;

import java.util.ArrayList;

public class SolutionsOne {

  public String solution(String sentence) {
    StringBuilder answer = new StringBuilder();
    int status = 0;
    ArrayList<Character> standards = new ArrayList<>();
    char exChar = ' ';
    boolean[] used = new boolean['z' - 'a' + 1];
    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);
      System.out.println("c : " + c + " status : " + status);
      if (status == 0) {
        standards.clear();
        if (isCapital(c)) {
          status = 1;
          answer.append(c);
        } else {
          status = 2;
          if (!used[c - 'a']) {
            standards.add(c);
            used[c - 'a'] = true;
          } else {
            return "invalid";
          }
        }
        exChar = c;
      } else if (status == 1) {
        if (isCapital(c)) {
          if (isCapital(exChar)) {
            answer.append(" ");
            status = 0;
            i--;
          } else {
            answer.append(c);
          }
        } else {
          if (isCapital(exChar)) {
            if (standards.isEmpty()) {
              if (!used[c - 'a']) {
                standards.add(c);
                used[c - 'a'] = true;
              } else {
                return "invalid";
              }
            } else if (c != standards.get(standards.size() - 1)) {
              if (!used[c - 'a']) {
                standards.set(standards.size() - 1, c);
                used[c - 'a'] = true;
              } else {
                return "invalid";
              }
              answer.append(" ");
              status = 2;
            }
          } else {
            return "invalid";
          }
        }
        exChar = c;
      } else if (status == 2) {
        if (isCapital(c)) {
          if (i != sentence.length() - 1) {
            return "invalid";
          }
          answer.append(c);
        } else {
          if (isCapital(exChar)) {
            if (c == standards.get(0)) {
              if (i != sentence.length() - 1) {
                status = 0;
                answer.append(" ");
              }
            } else {
              if (standards.size() == 1) {
                if (!used[c - 'a']) {
                  standards.add(c);
                  used[c - 'a'] = true;
                } else {
                  return "invalid";
                }
              } else if (standards.size() == 2 && c != standards.get(1)) {
                return "invalid";
              }
            }
          } else {
            return "invalid";
          }
        }
        exChar = c;
      }
    }
    return answer.toString();
  }

  boolean isCapital(char c) {
    return c >= 'A' && c <= 'Z';
  }
}