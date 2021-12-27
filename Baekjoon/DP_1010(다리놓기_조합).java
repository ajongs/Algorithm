import java.util.*;
import java.io.*;

class Main{
  static int[][] dp = new int[30][30];
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<T; i++){
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      sb.append(com(M,N)).append("\n");
    }
    System.out.print(sb);
  }
  public static int com(int n, int r){
    if(dp[n][r]>0){
      return dp[n][r];
    }
    if(n==r || r==0){
      return dp[n][r] = 1;
    }

    return dp[n][r] = com(n-1, r-1)+com(n-1, r);
  }
}
