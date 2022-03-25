import java.io.*;
import java.util.*;

class Main{
    static int v;
    static int e;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            String[] temp = br.readLine().split(" ");
            v = Integer.parseInt(temp[0]);
            e = Integer.parseInt(temp[1]);
            int[][] adj = new int[v+1][v+1];
            for(int j=0; j<e; j++){
                String[] vertex = br.readLine().split(" ");
                adj[Integer.parseInt(vertex[0])][Integer.parseInt(vertex[1])] =1;
                adj[Integer.parseInt(vertex[1])][Integer.parseInt(vertex[0])] =1;
            }
            bfs(adj);
        }
    }
    public static void bfs(int[][] adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] type = new int[v+1];
        for(int i=1; i<v+1; i++){
            if(type[i]==0){
                type[i] = 1;
                q.offer(i);
            }
            while(!q.isEmpty()){
                int cur = q.poll();

                for(int next=1; next<v+1; next++){
                    if(adj[cur][next]==1){
                        if(type[next]==0){
                            if(type[cur]==1)
                                type[next]=2;
                            else
                                type[next] =1;
                            q.offer(next);
                        }
                        else if(type[next] == type[cur]){
                            System.out.println("NO");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("YES");
    }
}
