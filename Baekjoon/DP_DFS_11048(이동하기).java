import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;
    static int[] dr = {1,0,1};
    static int[] dc = {0,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        dp = new int[n][m];


        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
                dp[i][j] = -1;
            }
        }
        dfs(0,0);
        System.out.println(dp[0][0]);

    }
    static int dfs(int r, int c){
        if(r==n-1 && c == m-1){
            return map[r][c];
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        dp[r][c] = 0;
        for(int i=0; i<3; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR >=0 && nextR <n && nextC >=0 && nextC < m){
                dp[r][c] = Math.max(dfs(nextR, nextC)+map[r][c] , dp[r][c]);
            }
        }
        return dp[r][c];
    }
}
