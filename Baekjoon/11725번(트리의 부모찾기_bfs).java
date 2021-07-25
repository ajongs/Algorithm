import java.util.*;
import java.io.*;
class Main {
  static List<Integer> []map;
  static int[] parent;
  static Boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    map = new ArrayList[n+1];
    parent = new int[n+1];
    visited = new Boolean[n+1];
    for(int i=1; i<n+1; i++){
      map[i] = new ArrayList<>();
      visited[i] = false;
    }

    for(int i=0; i<n-1; i++){
      String[] st = br.readLine().split(" ");
      int a = Integer.parseInt(st[0]);
      int b = Integer.parseInt(st[1]);
      map[a].add(b);
      map[b].add(a);
    }
    bfs(1);
    for(int i=2; i<n+1; i++){
      System.out.println(parent[i]);
    }
  }
  static void bfs(int start){
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);

    while(!q.isEmpty()){
      int num = q.poll();
      visited[num] = true;

      for(int i=0; i<map[num].size(); i++){
        int child = map[num].get(i);
        if(!visited[child]){
          parent[child] = num;
          q.offer(child);
        }
      }
    }
  }
}
