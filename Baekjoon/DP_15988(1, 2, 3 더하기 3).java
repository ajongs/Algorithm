import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000009;
    static final int INDEX = 1000001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[INDEX];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < INDEX; i++) {
            dp[i] = ((dp[i-1] + dp[i-2]) % MOD + dp[i-3]) % MOD;
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
