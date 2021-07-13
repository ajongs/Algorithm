import java.util.*;
import java.io.*;

class Main {
  public static boolean[] visited;
  public static int[][] graph;
  public static long result=0;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    visited = new boolean[n+1];
    graph = new int[n+1][n+1];
    //초기화
    for(int i=0; i<n+1; i++){
      for(int j=0; j<n+1; j++){
        graph[i][j] = 0;
      }
      visited[i] = false;
    }

    for(int i=0; i<n-1; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph[v2][v1] = graph[v1][v2] = Integer.parseInt(st.nextToken());
    }
    dfs(1,0,n);
    System.out.println(result);
  }

  public static void dfs(int x, long d, int n){
    visited[x] = true;
    int flag = 0;
    for(int i=1; i<n+1 ; i++){
      if(!visited[i] && graph[x][i]>0){
        flag = 1;
      }
    }

    if(flag == 0){
      if(result<d){
        result = d;
      }
      return;
    }
    
    for(int i=1; i<n+1 ; i++){
      if(!visited[i] && graph[x][i]>0){
        dfs(i, d+graph[x][i], n);
      }
    }
  }
}
