import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n+1];
        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        String[] str = br.readLine().split(" ");
        for(int i=1; i<n+1; i++){
            A[i] = Integer.parseInt(str[i-1]);
        }
        
        for(int k=1; k<=n; k++){
            d1[k]=1;
            for(int i=1; i<k; i++){
                if(A[k] > A[i] && d1[k]<d1[i]+1){
                    d1[k] = d1[i]+1;
                }
            }
        }
        
        for(int k=n; k>0; k--){
            d2[k]=1;
            for(int i=n; i>k; i--){
                if(A[k] > A[i] && d2[k]<d2[i]+1){
                    d2[k] = d2[i]+1;
                }
            }
        }
        int ans=0;
        for(int i=1; i<=n; i++){
            if(ans < d1[i]+d2[i]-1)
                ans = d1[i]+d2[i]-1;
        }
        System.out.println(ans);
    }
}
