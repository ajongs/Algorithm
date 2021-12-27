import java.io.*;
import java.util.*;

class Main {
  static int[][][] map;
  static int M;
  static int N;
  static int H;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    M = Integer.parseInt(str[0]);
    N = Integer.parseInt(str[1]);
    H = Integer.parseInt(str[2]);
    map = new int[H][N][M];
    
  
    int count=0;
    for(int i=0; i<H; i++){
      for(int j=0; j<N; j++){
        String[] st = br.readLine().split(" ");
        for(int k=0; k<M; k++){
          map[i][j][k] = Integer.parseInt(st[k]);
          if(map[i][j][k]==1 || map[i][j][k]==-1){
            count++;
          }
        }
      }
    }
    
    if(count==N*H*M){
      System.out.println(0);
    }
    else{
      bfs();
    }
  }
  static void bfs(){
    Queue<int[]> q = new LinkedList<>();
    int[] dx = {-1, 1, 0, 0, 0, 0};
    int[] dy = {0, 0, -1, 1, 0, 0};
    int[] dz = {0, 0, 0, 0, -1, 1};
    int day=0;
    for(int i=0; i<H; i++){
      for(int j=0; j<N; j++){
        for(int k=0; k<M; k++){
          if(map[i][j][k]==1){
            q.offer(new int[]{i,j,k,0});
          }
        }
      }
    }
    while(!q.isEmpty()){
      int[] current = q.poll();
      for(int i=0; i<6; i++){
        int nx = current[0] + dx[i];
        int ny = current[1] + dy[i];
        int nz = current[2] + dz[i];
        day = current[3];
        if(nx>=0 && nx<H && ny>=0 && ny<N && nz>=0 && nz<M){
          if(map[nx][ny][nz] == 0){
            map[nx][ny][nz] =1;
            q.offer(new int[]{nx, ny, nz, day+1});
          }
        }
      }
    }
    
    for(int i=0; i<H; i++){
      for(int j=0; j<N; j++){
        for(int k=0; k<M; k++){
          if(map[i][j][k]==0){
            System.out.println(-1);
            return;
          }
        }
      }
    }
    System.out.println(day);
  }
}
