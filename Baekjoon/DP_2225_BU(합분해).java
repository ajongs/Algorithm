import java.io.*;

class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        
        long[][] d = new long[k+1][n+1];
        d[0][0] = 1L;
        for(int i=1; i<=k; i++){
            for(int j=0; j<=n; j++){
                for(int l=0; l<=j; l++){
                    d[i][j] += d[i-1][j-l];
                    d[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(d[k][n] %= 1000000000);
    }
    
}
