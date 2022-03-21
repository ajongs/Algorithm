import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] horseDx = {2,2,-2,-2,1,1,-1,-1};
    static int[] horseDy = {-1,1,-1,1,2,-2,2,-2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int w = Integer.parseInt(str[0]);
        int h = Integer.parseInt(str[1]);

        int[][] map = new int[h][w];
        int[][][] dis = new int[k+1][h][w];

        int answer = Integer.MAX_VALUE;

        for(int i=0; i<k+1; i++){
            for(int j=0; j<h; j++){
                for(int z=0; z<w; z++){
                    dis[i][j][z] = Integer.MAX_VALUE;
                }
            }
        }



        for(int i=0; i<h; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<w; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0, k, 0));
        while(!q.isEmpty()){
            Point cp = q.poll();

            if(cp.h==h-1 && cp.w==w-1){
                answer = Math.min(answer, cp.dis);
                continue;
            }

            if(cp.k>0){
                //horse가능
                for(int i=0; i<8; i++){
                    int nx = cp.h + horseDx[i];
                    int ny = cp.w + horseDy[i];
                    if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny] == 0){
                        int newDis = cp.dis+1;
                        if(dis[cp.k-1][nx][ny] > newDis){
                            dis[cp.k-1][nx][ny] = newDis;
                            q.offer(new Point(nx, ny, cp.k -1, newDis));
                        }
                    }
                }
            }
            for(int i=0; i<4; i++){
                int nx = cp.h + dx[i];
                int ny = cp.w + dy[i];
                if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny] == 0){
                    int newDis = cp.dis+1;
                    if(dis[cp.k][nx][ny] > newDis){
                        dis[cp.k][nx][ny] = newDis;
                        q.offer(new Point(nx, ny, cp.k, newDis));
                    }
                }
            }
        }
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else
            System.out.println(answer);

    }
    static class Point{
        int h;
        int w;
        int k;
        int dis;
        Point(int h, int w, int k, int dis){
            this.h = h;
            this.w = w;
            this.k = k;
            this.dis = dis;
        }
    }
}
