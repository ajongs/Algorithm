import java.io.*;
import java.util.*;

class Main{
    static int m;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx= {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        m = Integer.parseInt(st[0]);
        n = Integer.parseInt(st[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        int count=0;
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1){
                    count++;
                }
            }
        }
        if(count==n*m){
            System.out.println(0);
            return;
        }
        bfs();
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        int day=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1){
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] current = q.poll();
            day = current[2];
            for(int i=0; i<4; i++){
                int nx = current[0]+dx[i];
                int ny = current[1]+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(map[nx][ny]==0){
                        map[nx][ny]=1;
                        q.offer(new int[]{nx, ny, day+1});
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day);
    }
}
