import java.io.*;

class Main{
    static int[] D;
    static int[] A; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split(" ");
        A = new int[n];
        D = new int[n];
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        D[0] = A[0];
        dp(n-1);
        
        int ans = D[0];
        for(int i=1; i<n; i++){
            if(ans < D[i])
                ans = D[i];
        }
        System.out.println(ans);
    }
    public static int dp(int n){
        if(n==0 || D[n]>0){
            return D[n];
        }
        D[n] = A[n];
        if(D[n]< dp(n-1)+A[n]){
            D[n] = dp(n-1)+A[n];
        }
        return D[n];
    }
}
