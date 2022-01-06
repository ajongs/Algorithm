import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans=0;
        String[] str = br.readLine().split(" ");
        int[] A = new int[n+1];
        int[] d = new int[n+1];
        
        for(int i=0; i<n; i++){
            A[i+1] = Integer.parseInt(str[i]);
        }
        
        
        for(int i=1; i<=n; i++){
            d[i] = 1;
            for(int j=1; j<i; j++){
                if(A[i]<A[j] && d[i] < d[j]+1){
                    d[i] = d[j] + 1;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(ans < d[i])
                ans = d[i];
        }
        System.out.println(ans);
    }
}
