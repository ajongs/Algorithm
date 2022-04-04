import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int m;
    static boolean visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            String history="";
            visited[i] = true;
            dfs(1,i, history+i);
            visited[i] = false;
        }

    }
    public static void dfs(int depth, int start, String history){
        if(depth == m){
            System.out.println(history);
            return;
        }
        for(int i=1; i<=n; i++){
            if(i==start) continue;
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, i, history+" "+i);
                visited[i] = false;
            }
        }
    }

}
