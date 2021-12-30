import java.io.*;

class Main{
  static int dp[][];
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    dp = new int[n+1][10];
    for(int i=1; i<10; i++){
      dp[1][i] = 1;
    }
    long ans=0;
    for(int l=0; l<10; l++){
      ans += stairNum(n, l); 
    }
    System.out.println(ans % 1000000000);
  }
  public static int stairNum(int n, int l){
    if(n==1 || dp[n][l]>0){ //dp 에서는 배열에 값 있는건 바로바로 출력해서 사용하는 것이 핵심!!!
      // 빠뜨지리말자 --dp[n][l]>0 --
      return dp[n][l] % 1000000000;
    }
    if(l==0) dp[n][l] = stairNum(n-1, l+1);
    else if(l==9) dp[n][l] = stairNum(n-1, l-1);
    else dp[n][l] = stairNum(n-1, l+1) + stairNum(n-1, l-1);
    
    return dp[n][l] % 1000000000;
  }
}
