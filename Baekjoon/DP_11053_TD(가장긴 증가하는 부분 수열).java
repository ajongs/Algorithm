import java.io.*;

class Main{
    static int[] d;
    static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new int[n+1];
        d = new int[n+1];
        int answer=0;

        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            A[i+1] = Integer.parseInt(str[i]);
        }
        
        d[1] = 1;
        
        start(n);
        
        for(int i=1; i<=n; i++){
          if(answer < d[i])
            answer =d[i];
        }
        System.out.println(answer);

    }
    public static int dp(int n){
        if(n==1 || d[n]>0){
            return d[n];
        }
        //A값 체크
        d[n] =1;
        for(int i=n-1; i>0; i--){
            if(A[n] > A[i]){ // 그중 만족하는거로 dp(n)돌려야지
                int temp = dp(i)+1;
                if(d[n]<temp){
                    d[n] = temp;
                }
            }
        }
        return d[n];
    }
    public static void start(int n){
        if(n==0){
            return;
        }
        else
            dp(n);
            start(n-1);
    }
}
