import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        adj= new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            str = br.readLine().split(" ");
            int first = Integer.parseInt(str[0]);
            int second = Integer.parseInt(str[1]);

            adj[second].add(first);
        }
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            dfs(i);
        }
    }
    public static void dfs(int n){
        visited[n] = true;
        if(adj[n] == null){
            System.out.print(n+" ");
            return;
        }
        for(int i=0; i<adj[n].size(); i++){
            int num = adj[n].get(i);
            if(visited[num]) continue;
            dfs(num);
        }
        System.out.print(n+" ");
    }
}
