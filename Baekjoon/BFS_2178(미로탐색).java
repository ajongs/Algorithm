import java.util.*;
import java.io.*;

class Main{
    static int[][] graph;
    static int N, M;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        
        graph = new int[N][M];
        for(int i=0;i<N;i++){
            String[] data = br.readLine().split("");
            for(int j=0; j<M;j++){
                graph[i][j] = Integer.parseInt(data[j]);
            }
        }
        bfs();
        
    }
    static void bfs(){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        graph[0][0] = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            
            if(N-1==current[0] && M-1==current[1]){
               System.out.println(current[2]);  
               return;
            }
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx >=0 && nx <N && ny >=0 && ny<M && graph[nx][ny]==1){
                    graph[nx][ny] = 0;
                    q.offer(new int[]{nx, ny, current[2]+1});
                }
            }
        }
    }
}
