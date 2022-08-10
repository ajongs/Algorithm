
import java.io.*;

class Main{
    static int n;
    static int m;
    static int[][] map;
    static int[] dr = {-1,0,1,0}; //북동남서 인덱스 순
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited;
    static int result=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        str = br.readLine().split(" ");
        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        int d = Integer.parseInt(str[2]);

        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");

            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        visited[r][c] = true;
        result++;
        dfs(r,c,d);
        System.out.println(result);
    }
    public static void dfs(int r, int c, int d){
        //더이상 탐색할 곳이 없으면 멈춤
        //네 방향이 이미 청소 끝이고 후진 한 곳이 벽인 경우 return
        boolean isAllSearch = true;
        int dir = d;
        for(int i=0; i<4; i++){
            dir = (dir+3)%4;
            int nextR = r+dr[dir];
            int nextC = c+dc[dir];

            if(nextR >0 && nextR<n && nextC >0 && nextC <m){
                //방문하지 않았고 벽이 아닌경우 가서 조회
                if(map[nextR][nextC] != 1 && !visited[nextR][nextC]){
                    result++;
                    visited[nextR][nextC] = true;
                    isAllSearch = false;
                    dfs(nextR, nextC, dir);
                    break;
                }
            }
        }

        if(isAllSearch){
            int backD = (d+2)%4;
            int nextR = r+dr[backD];
            int nextC = c+dc[backD];

            if(nextR >0 && nextR<n && nextC >0 && nextC <m){
                if(map[nextR][nextC] != 1){
                    dfs(nextR, nextC, d); //바라보는 방향은 그대로 후진 1칸
                }
                else
                    return;
            }

        }

    }
}
