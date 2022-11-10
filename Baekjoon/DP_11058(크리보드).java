import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            if (i > 6) {
                for (int j = 3; j < 6; j++) {
                    dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
                }
            }
        }
        System.out.println(dp[n]);
    }
}
