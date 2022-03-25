import java.io.*;
import java.util.*;

class Main{
    static int[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int l = Integer.parseInt(br.readLine());
            int sr,sc, er, ec;
            String[] temp = br.readLine().split(" ");
            sr = Integer.parseInt(temp[0]);
            sc = Integer.parseInt(temp[1]);
            String[] temp2 = br.readLine().split(" ");
            er = Integer.parseInt(temp2[0]);
            ec = Integer.parseInt(temp2[1]);

            System.out.println(bfs(sr,sc,er,ec,l));
        }
    }
    public static int bfs(int sr, int sc, int er, int ec, int l){
        visited = new int[l][l];
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                visited[i][j] = -1;
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sr,sc));
        visited[sr][sc] = 0;

        while(!q.isEmpty()){
            Point cp = q.poll();

            if(cp.r == er && cp.c == ec){
                return visited[er][ec];
            }
            int[] dx = {-2,-2,2,2,1,1,-1,-1};
            int[] dy = {1,-1,1,-1,-2,2,-2,2};
            for(int i=0; i<dx.length; i++){
                int nr = cp.r + dx[i];
                int nc = cp.c + dy[i];
                if(nr>=0 && nr<l && nc>=0 && nc<l){
                    if(visited[nr][nc] == -1){
                        visited[nr][nc] = visited[cp.r][cp.c] +1;
                        q.offer(new Point(nr,nc));
                    }
                }
            }
        }
        return -1;
    }
    static class Point{
        int r;
        int c;
        Point(int r, int c){
            this.r =r ;
            this.c = c;
        }

    }
}
