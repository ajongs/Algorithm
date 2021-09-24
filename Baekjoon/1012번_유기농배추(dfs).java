import java.io.*;
class Main{
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0 ,0};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i=0; i<t; i++){
            String[] str = br.readLine().split(" ");
            m = Integer.parseInt(str[0]);
            n = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            map = new int[n][m];
            int count=0;
            for(int j=0; j<k; j++){
                String[] st = br.readLine().split(" ");
                int x = Integer.parseInt(st[0]);
                int y = Integer.parseInt(st[1]);
                map[y][x] = 1;
            }
          for(int x=0; x<n; x++){
            for(int y=0; y<m; y++){
              if(map[x][y]!=0){
                dfs(x,y);
                
                count++;
              }
            }
          }
          System.out.println(count);
        }
    }
    static void dfs(int x, int y){
      map[x][y]=0;
      for(int i=0; i<4; i++){
        int nx = x+dx[i];
        int ny = y+dy[i];
        if(nx>=0 && nx<n && ny>=0 && ny<m){
          if(map[nx][ny]==1)
            dfs(nx, ny);
        }
      }
    } 
}
