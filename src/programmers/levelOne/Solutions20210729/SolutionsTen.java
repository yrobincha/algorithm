package programmers.levelOne.Solutions20210729;

import java.util.Scanner;

public class SolutionsTen {

  public void solution() {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    for (int i = 0; i < b; i++) {
      for (int j = 0; j < a; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}