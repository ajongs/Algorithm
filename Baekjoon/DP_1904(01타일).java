import java.io.*;

class Main{
    static long dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(recursive(n));
    }
    static long recursive(int n){
        int mod = 15746;
        if(n==1 || n==2){ 
            return dp[n];
        }
        if(dp[n] > 0){
            return dp[n];
        }
        else{
            return dp[n] = ( recursive(n-2)% mod + recursive(n-1)%mod) % mod;
        }
    }
}
