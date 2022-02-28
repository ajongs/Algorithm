import java.io.*;
import java.util.*;

class Main{
    static int n,m,k;
    static int[][] map;
    static int[][][] dis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);
        map = new int[n][m];
        dis = new int[n][m][k+1];

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        bfs();

        int min=2147483647;
        for(int i=0; i<=k; i++){
            if(dis[n-1][m-1][i]>0 && dis[n-1][m-1][i]< min){
                min = dis[n-1][m-1][i];
            }
        }
        if(min==2147483647){
            bw.write(Integer.toString(-1));
            bw.flush();
            return;
        }
        bw.write(Integer.toString(min));

        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,0));
        dis[0][0][0]=1;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        while(!q.isEmpty()){
            Point cp = q.poll();

            for(int i=0; i<4; i++){
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(map[nx][ny]==0 && dis[nx][ny][cp.z]==0){
                        dis[nx][ny][cp.z] = dis[cp.x][cp.y][cp.z] + 1;
                        q.offer(new Point(nx, ny, cp.z));
                    }
                    else if(cp.z+1 <= k && map[nx][ny]==1 && dis[nx][ny][cp.z+1]==0){
                        dis[nx][ny][cp.z+1] = dis[cp.x][cp.y][cp.z] +1;
                        q.offer(new Point(nx, ny, cp.z+1));
                    }
                }
            }
        }
    }
    static class Point{
        int x;
        int y;
        int z;
        Point(int x, int y, int z){
            this.x = x ;
            this.y = y;
            this.z = z;
        }
    }
}
