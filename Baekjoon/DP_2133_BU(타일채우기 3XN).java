import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] d = new int[n+2]; //n+1로 하면 ArrayIndexOutOfBounds에러남.
        
        d[0]=1;
        d[2]=3;
        for(int i=4; i<n+2; i+=2){
              d[i] = d[i-2] * d[2];
              for(int j=i-4; j>=0; j-=2){
                  d[i] += 2* d[j];
              
            }
            
        }
        
        System.out.println(d[n]);
    }
}
