import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n][n];
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int start = arr[0][0];
        dp[0+start][0] = 1;
        dp[0][0+start] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                if (i == n-1 && j == n-1) break;
                int move = arr[i][j];
                if (i+move < n) {
                    dp[i+move][j] += dp[i][j];
                }
                if (j+move < n) {
                    dp[i][j+move] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
