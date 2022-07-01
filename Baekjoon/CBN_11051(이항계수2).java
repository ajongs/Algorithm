import java.io.*;

class Main{
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        dp = new int[n+1][k+1];
        
        System.out.println(combination(n,k));
    }
    
    static int combination(int n, int k){
        if(dp[n][k] > 0){
            return dp[n][k];
        }
        if(n==k || k==0){
            return dp[n][k] = 1;
        }
        else
            return dp[n][k] = (combination(n-1,k-1) + combination(n-1,k))%10007;
    }
}

//이항계수 구하기
// nCr = (n-1 C r-1 )+(n-1 C r) 과 같음
// n==k , k==0 일때는 1로 예외처리 해줘야함

// 재귀는 부분문제가 중복될때 새롭게 다시푼다 --> 메모제이션 필요 -> 시간 
