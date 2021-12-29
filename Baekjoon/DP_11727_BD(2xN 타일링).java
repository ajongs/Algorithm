import java.io.*;

class Main{
    static int d[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        d[1]=1;
        d[2]=3;
        System.out.println(dp(n));
    }
    public static int dp(int n){
        if(n>2){
            for(int i=3 ; i<=n; i++){
                d[i] = d[i-1] + 2 * d[i-2];
                d[i] %= 10007;
            }  
        }
        return d[n];
    }
}
