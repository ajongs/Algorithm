import java.io.*;
import java.util.*;

class Main{
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List<Integer> group_count = new ArrayList<>();
    static int[][] group;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        group = new int[n][m];
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==false && map[i][j] == 0){
                    bfs(i,j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1){
                    Set<Integer> set = new HashSet<>();
                    int count=1;
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx>=0 && nx<n && ny>=0 && ny<m){
                            if(map[nx][ny]==0){
                                int g = group[nx][ny];
                                set.add(g);
                            }
                        }
                    }
                    for(Integer a : set){
                        count += group_count.get(a);
                    }
                    bw.write(Integer.toString(count%10));
                }
                else{
                    bw.write(Integer.toString(0));
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;
        int g = group_count.size();
        group[x][y] = g;
        int count =1;
        while(!q.isEmpty()){
            Point cp = q.poll();

            for(int i=0; i<4; i++){
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(visited[nx][ny] == false && map[nx][ny]==0){
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                        //그룹 추가도 해야되고
                        group[nx][ny] = g;
                        //그룹 카운트도 해야함
                        count++;
                    }
                }
            }
        }
        group_count.add(count);
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
