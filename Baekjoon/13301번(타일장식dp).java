import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    long dp[] = new long[81];
    dp[1] =1;
    dp[2]=1;
    for(int i=3; i<dp.length; i++){
      dp[i] = dp[i-2] + dp[i-1];
    }

    System.out.println(2*(2*dp[n]+dp[n-1]));
  }
}
