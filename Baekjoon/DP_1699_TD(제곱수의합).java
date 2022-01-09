import java.io.*;

class Main{
    static int[] D;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        D = new int[n+1];
        
        System.out.println(dp(n));
        
    }
    public static int dp(int n){
        if(n==1){
            D[n] = n;
            return D[n];
        }
        if(D[n] > 0){
            return D[n];
        }
        D[n]=n;
        for(int i=1; i*i<=n; i++){
            if(D[n] > dp(n-i*i)+1)
                D[n] = dp(n-i*i)+1;
        }
        return D[n];
    }
}
