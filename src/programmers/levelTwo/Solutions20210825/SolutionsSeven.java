package programmers.levelTwo.Solutions20210825;

public class SolutionsSeven {

  public String solution(String m, String[] musicinfos) {
    String answer = "(None)";
    int max = 0;
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < m.length(); i++) {
      if (m.charAt(i) == '#') {
        builder.setCharAt(builder.length() - 1, (char) (m.charAt(i - 1) - 'A' + 'a'));
      } else {
        builder.append(m.charAt(i));
      }
    }
    m = builder.toString();

    for (String musicInfo : musicinfos) {
      String[] info = musicInfo.split(",");
      String[] start = info[0].split(":");
      int startH = Integer.parseInt(start[0]);
      int startM = Integer.parseInt(start[1]);
      String[] end = info[1].split(":");
      int endH = Integer.parseInt(end[0]);
      int endM = Integer.parseInt(end[1]);
      int time;
      if (startM > endM) {
        time = endM + 60 - startM + (endH - 1 - startH) * 60;
      } else {
        time = (endH - startH) * 60 + endM - startM;
      }

      String name = info[2];
      String scales = info[3];
      builder = new StringBuilder();
      for (int i = 0; i < scales.length(); i++) {
        if (scales.charAt(i) == '#') {
          builder.setCharAt(builder.length() - 1, (char) (scales.charAt(i - 1) - 'A' + 'a'));
        } else {
          builder.append(scales.charAt(i));
        }
      }
      scales = builder.toString();

      String music = scales.repeat(Math.max(0, time / scales.length())) + scales.substring(0,
          time % scales.length());

      if (music.contains(m) && time > max) {
        max = time;
        answer = name;
      }
    }
    return answer;
  }
}