
import java.io.*;
import java.util.*;

class Main{
    static int[][] map;
    static int[][][] dis;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        dis = new int[n][m][2];
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        bfs();
        if(dis[n-1][m-1][1] > 0  && dis[n-1][m-1][0] > 0){
            System.out.println(Math.min(dis[n-1][m-1][1] , dis[n-1][m-1][0] ));
        }
        else if(dis[n-1][m-1][1] == 0 && dis[n-1][m-1][0] == 0){
            System.out.println(-1);
        }
        else if(dis[n-1][m-1][1] == 0 || dis[n-1][m-1][0] == 0){
            System.out.println(Math.max(dis[n-1][m-1][1] , dis[n-1][m-1][0]));
        }
    }
    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        dis[0][0][0] = 1;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        q.offer(new Point(0,0,0));
        while(!q.isEmpty()){
            Point cp = q.poll();

            for(int i=0; i<4; i++){
                int x = cp.x + dx[i];
                int y = cp.y + dy[i];

                if(x>=0 && x<n && y>=0 && y<m){
                    if(map[x][y] ==0 && dis[x][y][cp.z]==0){
                        dis[x][y][cp.z] = dis[cp.x][cp.y][cp.z] + 1;
                        q.offer(new Point(x,y, cp.z));

                    }
                    else if(cp.z==0 && map[x][y]==1 && dis[x][y][cp.z+1]==0  ){
                        dis[x][y][cp.z+1] = dis[cp.x][cp.y][cp.z]+1;
                        q.offer(new Point(x,y, 1));
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
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

/*
import java.io.*;
import java.util.*;

class Main{
    static int[][] map;
    static int shortDis;
    static List<Point> wall = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        map = new int[n][m];
        shortDis = n*m;
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
                if(map[i][j] == 1){
                    wall.add(new Point(i,j));
                }
            }
        }

        for(int i=0; i<wall.size(); i++){
            //여기서는 맵을 벽을 하나씩 부서놓는다
            Point p = wall.get(i);
            int x = p.x;
            int y = p.y;
            map[x][y] = 0;

            //여기서 bfs 돌려본다.
            bfs(n, m);
            map[x][y] = 1;
        }
        if(shortDis==n*m){
            System.out.println(-1);
        }
        else
            System.out.println(shortDis);
    }
    static void bfs(int n, int m){
        int[][] dist= new int[n][m];
        boolean[][] visited= new boolean[n][m];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));
        visited[0][0]=true;
        dist[0][0] = 1;
        while(!q.isEmpty()){
            Point cp = q.poll();
            for(int i=0; i<4; i++){
                int x = cp.x+dx[i];
                int y = cp.y+dy[i];
                if(x>=0 && x<n && y>=0 && y<m){
                    if(map[x][y]==0 && visited[x][y] == false){
                        visited[x][y] = true;
                        q.offer(new Point(x,y));
                        dist[x][y] = dist[cp.x][cp.y]+1;
                    }
                }
            }
        }
        if(dist[n-1][m-1]>0){
            shortDis = Math.min(shortDis, dist[n-1][m-1]);
        }
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
*/
