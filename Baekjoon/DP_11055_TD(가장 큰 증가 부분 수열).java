import java.io.*;

class Main{

    static int[] d;
    static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        
        d = new int[n+1];
        A = new int[n+1];
        int answer = 0;
        
        for(int i=1; i<n+1; i++){
            A[i] = Integer.parseInt(str[i-1]);        
        }   
        
        d[1] = A[1];
        start(n);
        
        for(int i=1; i<n+1; i++){
            if(answer < d[i])
                answer = d[i];
        }
        System.out.println(answer);
    } 
    public static int dp(int n){
        if(n==1 || d[n]>0){
            return d[n];
        }
        d[n] = A[n];
        for(int i=n-1; i>0; i--){
            if(A[n]>A[i] && d[n]<dp(i)+A[n])
                d[n] = dp(i)+A[n];
        }
        return d[n];
    }
    public static void start(int n){
        if(n==0)
            return;
        dp(n);
        start(n-1);
    }
}
