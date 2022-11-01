import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[][][] dp;
    static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n+1][10][1<<10];

        for(int i=1; i<10; i++){
            dp[1][i][1<<i] = 1;
        }

        for(int i=2; i<=n; i++){ //자리 개수
            for(int j=0; j<10; j++){ //끝자리 수
                for(int k=0; k<(1<<10); k++){ //비트

                    int bit = k|(1<<j);

                    if(j==0)
                        dp[i][j][bit] += dp[i-1][j+1][k] % MOD;
                    else if(j==9)
                        dp[i][j][bit] += dp[i-1][j-1][k] % MOD;
                    else
                        dp[i][j][bit] += dp[i-1][j-1][k] % MOD + dp[i-1][j+1][k] % MOD;

                    dp[i][j][bit] %= MOD;
                }
            }
        }
        long sum =0;
        for(int i=0; i<10; i++){
            sum += dp[n][i][(1<<10)-1] % MOD;
            sum %= MOD;
        }
        System.out.println(sum);
    }
}
