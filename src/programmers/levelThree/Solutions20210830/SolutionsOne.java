package programmers.levelThree.Solutions20210830;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;

public class SolutionsOne {

  public int solution(String[] lines) {
    int answer = 0;
    HashMap<String, Pair> timeMap = new HashMap<>();
    for (String line : lines) {
      String[] splits = line.split(" ");
      String[] milli = splits[2].replaceAll("s", "").split("\\.");
      long end = Timestamp.valueOf(splits[0] + " " + splits[1]).getTime();
      long start = end + 1;
      start -= Long.parseLong(milli[0]) * 1000 + (milli.length == 2 ? Long.parseLong(milli[1]) : 0);
      timeMap.put(line, new Pair(start, end));
    }

    Arrays.sort(lines, ((o1, o2) -> (int) (timeMap.get(o2).start - timeMap.get(o1).start)));
    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];
      long tStart = timeMap.get(line).start;
      long tEnd = tStart + 1000 - 1;
      int count = 1;
      for (int j = 0; j < lines.length; j++) {
        if (i != j) {
          long start = timeMap.get(lines[j]).start;
          long end = timeMap.get(lines[j]).end;
          if (start <= tEnd && end >= tStart) {
            count++;
          }
        }
      }

      if (count > answer) {
        answer = count;
      }

      tStart = timeMap.get(line).end;
      tEnd = tStart + 1000 - 1;
      count = 1;
      for (int j = 0; j < lines.length; j++) {
        if (i != j) {
          long start = timeMap.get(lines[j]).start;
          long end = timeMap.get(lines[j]).end;
          if (start <= tEnd && end >= tStart) {
            count++;
          }
        }
      }

      if (count > answer) {
        answer = count;
      }
    }
    return answer;
  }
}

class Pair {

  long start;
  long end;

  public Pair(long start, long end) {
    this.start = start;
    this.end = end;
  }
}