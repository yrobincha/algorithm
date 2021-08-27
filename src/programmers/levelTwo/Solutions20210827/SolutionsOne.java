package programmers.levelTwo.Solutions20210827;

import java.util.Arrays;

public class SolutionsOne {

  public String[] solution(String[] files) {
    Arrays.sort(files, (s1, s2) -> {
      String[] file1 = parseFile(s1);
      String[] file2 = parseFile(s2);

      int result = file1[0].compareToIgnoreCase(file2[0]);

      if (result == 0) {
        int num1 = Integer.parseInt(file1[1]);
        int num2 = Integer.parseInt(file2[1]);
        result = num1 - num2;
      }
      return result;
    });
    return files;
  }

  private String[] parseFile(String s) {
    String[] file = new String[3];
    StringBuilder builder = new StringBuilder();

    int i = 0;
    for (; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= '0' && c <= '9') {
        break;
      }
      builder.append(c);
    }
    file[0] = builder.toString();
    builder = new StringBuilder();

    for (; i < s.length(); i++) {
      char c = s.charAt(i);
      if (builder.length() == 5 || (c < '0' || c > '9')) {
        break;
      }
      builder.append(c);
    }
    file[1] = builder.toString();
    file[2] = s.substring(i);

    return file;
  }
}