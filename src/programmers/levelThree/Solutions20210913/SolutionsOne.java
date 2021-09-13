package programmers.levelThree.Solutions20210913;

public class SolutionsOne {

  String routes = "";

  public String[] solution(String[][] tickets) {
    boolean[] visited = new boolean[tickets.length];
    for (int i = 0; i < tickets.length; i++) {
      if (tickets[i][0].equals("ICN")) {
        StringBuilder builder = new StringBuilder(tickets[i][0]);
        builder.append(" ").append(tickets[i][1]);
        visited[i] = true;
        search(tickets, visited, builder, tickets[i][1]);
        visited[i] = false;
      }
    }
    return routes.split(" ");
  }

  void search(String[][] tickets, boolean[] visited, StringBuilder builder, String current) {
    if (allVisited(visited)) {
      if (routes.isEmpty() || builder.toString().compareTo(routes) < 0) {
        this.routes = builder.toString();
      }
      return;
    }
    for (int i = 0; i < tickets.length; i++) {
      if (!visited[i] && tickets[i][0].equals(current)) {
        visited[i] = true;
        StringBuilder s = new StringBuilder(builder);
        s.append(" ").append(tickets[i][1]);
        search(tickets, visited, s, tickets[i][1]);
        visited[i] = false;
      }
    }
  }

  boolean allVisited(boolean[] visited) {
    for (boolean b : visited) {
      if (!b) {
        return false;
      }
    }
    return true;
  }
}