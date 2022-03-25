import java.io.*;
import java.util.*;

class Main{
    static int[][] adj;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        adj = new int[n][n];

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split("");
            for(int j=0 ;j<n; j++){
                adj[i][j] = Integer.parseInt(temp[j]);
            }
        }
        List<Integer> count = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(adj[i][j]==1){
                    count.add(bfs(i,j,n));
                }
            }
        }
        Collections.sort(count);
        System.out.println(count.size());
        for(Integer a : count){
            System.out.println(a);
        }
    }
    public static int bfs(int r, int c, int n){
        int count =0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r,c));
        adj[r][c] = 0;
        while(!q.isEmpty()){
            Point cp = q.poll();

            count++;
            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};

            for(int i=0; i<4; i++){
                int nc = cp.c + dx[i];
                int nr = cp.r + dy[i];
                if(nc>=0 && nc<n && nr >=0 && nr<n && adj[nr][nc]==1){
                    adj[nr][nc] = 0;
                    q.offer(new Point(nr,nc));
                }
            }
        }
        return count;
    }
    static class Point{
        int r;
        int c;
        Point(int r, int c){
            this.r =r ;
            this.c =c;
        }
    }
}
