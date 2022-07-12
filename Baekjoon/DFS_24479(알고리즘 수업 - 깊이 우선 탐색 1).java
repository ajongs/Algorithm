import java.io.*;
import java.util.*;

class Main{
    static List<Integer>[] E;
    static int[] V;
    static int idx=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int start = Integer.parseInt(str[2]);
        E = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            E[i] = new ArrayList<>();
        }
        V = new int[n+1];
        for(int i=0; i<m; i++){
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            E[u].add(v);
            E[v].add(u);
        }
        for(int i=1; i<n+1; i++){
            Collections.sort(E[i]);
        }
        V[start] = ++idx;
        dfs(start);
        for(int i=1; i<n+1; i++){
            System.out.println(V[i]);
        }
    }
    static void dfs(int R){
        for (Integer next : E[R]) {
            if(V[next]==0){
                V[next] = ++idx;
                dfs(next);
            }
        }
    }
}
