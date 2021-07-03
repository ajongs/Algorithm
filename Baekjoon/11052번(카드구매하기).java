import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    //카드 가격정보
    int[] p = new int[n+1];
    //해당 개수 최대 가격
    int[] dp = new int[n+1];
    for(int i=1; i<n+1; i++){
      p[i] = sc.nextInt();
    }

    for(int i=1; i<=n; i++){
      for(int j=1; j<=i; j++){
        dp[i] = Math.max(dp[i], (dp[i-j]+p[j]));
      }
    }

    System.out.println(dp[n]);
  }
}
