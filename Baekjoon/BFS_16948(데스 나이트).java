import java.io.*;
import java.util.*;

class Main{
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int r1 = Integer.parseInt(str[0]);
        int c1 = Integer.parseInt(str[1]);

        int r2 = Integer.parseInt(str[2]);
        int c2 = Integer.parseInt(str[3]);

        int[] dr = {-2, -2, 0, 0, 2, 2};
        int[] dc = {-1, 1, -2, 2, -1, 1};

        dist = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = -1;
            }
        }

        dist[r1][c1] = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r1, c1));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<6; i++){
                int nextR = p.r + dr[i];
                int nextC = p.c + dc[i];
                if(nextR >=0 && nextR < n && nextC >=0 && nextC < n){
                    if(dist[nextR][nextC] == -1){
                        dist[nextR][nextC] = dist[p.r][p.c] + 1;
                        q.offer(new Point(nextR, nextC));
                    }
                }
            }
        }
        System.out.println(dist[r2][c2]);
    }
    static class Point{
        public int r;
        public int c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
