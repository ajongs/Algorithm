import java.io.*;

class Main {
  
  static ArrayList<int[]>[] graph;
  static boolean visited[];
  static int max=0;
  static int longestLeafNode=0;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    graph = new ArrayList[n+1];
    visited = new boolean[n+1];
    
    for(int i=1; i<=n; i++){
      graph[i] = new ArrayList<>();
    }
    String[] input;
    for(int i=0; i<n; i++){
      input = br.readLine().split(" ");
      int j=1;
      while(Integer.parseInt(input[j])!=-1){
        int v = Integer.parseInt(input[j]);
        int e = Integer.parseInt(input[j+1]);
        graph[Integer.parseInt(input[0])].add(new int[]{v,e});
        j += 2;
      }
    }
    visited[1] = true;
    dfs(1, 0);
    
    for(int i=1; i<=n; i++){
      visited[i] = false;
    }
    
    visited[longestLeafNode] = true;
    dfs(longestLeafNode, 0);
    
    System.out.println(max);
  }
  static void dfs(int start, int cost){
    if(cost>max){
      max = cost;
      longestLeafNode = start;
    }
    for(int[] node : graph[start]){
      int v = node[0];
      int e = node[1];
      if(!visited[v]){
        visited[v] = true;
        dfs(v, cost+e);
      }
    }
  }
}
