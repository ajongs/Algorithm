import java.io.*;

class Main{
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];
        
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }
        
        long ans = 0;
        for(int l=0; l<10; l++){
            ans += count(n, l);
        }
        
        System.out.println(ans % 10007);
    }
    public static long count(int n, int l){
        if(dp[n][l]>0 || n==1){
            return dp[n][l];
        }
        else{
            //n번째 K 가 들어온다 가정하면 n-1번째는 0~K 까지 들어올 수 있음
            for(int k=0; k<=l; k++){
                dp[n][l] += count(n-1, k);
                dp[n][l] %= 10007;
            }
            return dp[n][l];
        }
    }
}
