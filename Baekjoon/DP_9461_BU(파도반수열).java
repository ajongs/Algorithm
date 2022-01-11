import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n=0;
        for(int k=0; k<T; k++){
            n = Integer.parseInt(br.readLine());
            
            
            long[] d = new long[n+1];
            
            d[0] = 0;
            for(int i=1; i<=n; i++){
                if(i<4){
                    d[i] = 1;
                }
                else if(i>3 && i<6){
                    d[i] = 2;
                }
                else
                    d[i] = d[i-1]+d[i-5];
           }
        
            System.out.println(d[n]);
        }
        
    }
}
