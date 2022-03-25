import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    static int[][] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adj = new int[n+1][n+1];

        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            String[] temp = br.readLine().split(" ");
            adj[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 1;
            adj[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;
        }
        System.out.println(bfs(1, n));
    }
    public static int bfs(int start, int n){
        int answer =0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=1; i<n+1; i++){
                if(cur == i) continue;
                if(adj[cur][i]==1 && !visited[i]){
                    answer++;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return answer;
    }
}
