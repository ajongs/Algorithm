import java.io.*;

class Main{
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                dfs(i,j,1,map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);

    }
    static void dfs(int y, int x, int depth, int sum){
        if(depth ==4){
            max = Math.max(max, sum);
            return;
        }
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >=0 && nextX < m && nextY >=0 && nextY <n){
                if(!visited[nextY][nextX]){
                    // 'ㅓ', 'ㅗ' 'ㅜ' 'ㅏ' 를 위해서 두번째 노드에서는 자기 자신에서 갈 수 있는 곳을 탐색
                    if(depth == 2){
                        visited[nextY][nextX] = true;
                        dfs(y, x, depth+1, sum+map[nextY][nextX]);
                        visited[nextY][nextX] = false;
                    }
                    visited[nextY][nextX] = true;
                    dfs(nextY, nextX, depth+1, sum+map[nextY][nextX]);
                    visited[nextY][nextX] = false;
                }
            }
        }
    }
}
