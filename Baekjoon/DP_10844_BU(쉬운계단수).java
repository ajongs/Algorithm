import java.io.*;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n+1][10];
    long ans=0;
    
    for(int i=1; i<10; i++){
      dp[1][i]=1; 
    }
    for(int i=2; i<=n; i++){
      for(int j=0; j<10; j++){
        dp[i][j]=0;
        if(j==0) dp[i][j] = dp[i-1][j+1];
        else if(j==9) dp[i][j] = dp[i-1][j-1];
        else dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
        dp[i][j] %= 1000000000;
      }
    }
    for(int i=0; i<10; i++){
      ans += dp[n][i]; 
    }
    System.out.println(ans % 1000000000);
  }
}
