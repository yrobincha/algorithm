package programmers.levelOne.Solutions20210723;

public class SolutionsSix {

  public int solution(String dartResult) {
    int answer = 0;
    int score = 0;
    int previous = 0;
    for (int i = 0; i < dartResult.length(); i++) {
      char c = dartResult.charAt(i);
      if (c >= '0' && c <= '9') {
        score = c - '0';
        if (dartResult.charAt(i + 1) == '0') {
          score += 9;
          i++;
        }
      } else if (c == 'S') {
        if (i + 1 < dartResult.length()) {
          char option = dartResult.charAt(i + 1);
          if (option == '*') {
            answer += previous;
          }
          previous = calculateScore(score, 1, option);
        } else {
          previous = calculateScore(score, 1, 'x');
        }
        answer += previous;
      } else if (c == 'D') {
        if (i + 1 < dartResult.length()) {
          char option = dartResult.charAt(i + 1);
          if (option == '*') {
            answer += previous;
          }
          previous = calculateScore(score, 2, option);
        } else {
          previous = calculateScore(score, 2, 'x');
        }
        answer += previous;
      } else if (c == 'T') {
        if (i + 1 < dartResult.length()) {
          char option = dartResult.charAt(i + 1);
          if (option == '*') {
            answer += previous;
          }
          previous = calculateScore(score, 3, option);
        } else {
          previous = calculateScore(score, 3, 'x');
        }
        answer += previous;
      }
    }
    return answer;
  }

  int calculateScore(int score, int pow, char option) {
    int result = (int) Math.pow(score, pow);
    if (option == '*') {
      result *= 2;
    } else if (option == '#') {
      result *= -1;
    }
    return result;
  }
}