package programmers.levelThree.Solutions20210908;

public class SolutionsOne {

  public int solution(String begin, String target, String[] words) {
    boolean[] visited = new boolean[words.length];
    int answer = searchWords(begin, 0, words, target, visited, Integer.MAX_VALUE);
    return answer == Integer.MAX_VALUE ? 0 : answer;
  }

  int searchWords(String s, int count, String[] words, String t, boolean[] visited, int answer) {
    if (s.equals(t)) {
      return count;
    } else {
      for (int i = 0; i < words.length; i++) {
        if (!visited[i]) {
          int tmp = 0;
          for (int j = 0; j < s.length(); j++) {
            tmp += s.charAt(j) != words[i].charAt(j) ? 1 : 0;
          }

          if (tmp == 1) {
            visited[i] = true;
            answer = Math.min(answer, searchWords(words[i], count + 1, words, t, visited, answer));
            visited[i] = false;
          }
        }
      }
    }
    return answer;
  }
}