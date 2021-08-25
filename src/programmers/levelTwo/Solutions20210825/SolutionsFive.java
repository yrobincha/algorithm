package programmers.levelTwo.Solutions20210825;

public class SolutionsFive {

  public int solution(String skill, String[] skill_trees) {
    int answer = 0;
    for (String skill_tree : skill_trees) {
      int index = 0;
      int count = 0;
      for (int i = 0; i < skill_tree.length(); i++) {
        int si = skill.indexOf(skill_tree.charAt(i));
        if (si == index) {
          index++;
          if (index == skill.length()) {
            break;
          }
        } else if (si > index) {
          index = 0;
          break;
        } else if (si < 0) {
          count++;
        }
      }
      answer += index > 0 || count == skill_tree.length() ? 1 : 0;
    }
    return answer;
  }
}