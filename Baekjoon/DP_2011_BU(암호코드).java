import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int n = str.length;
        int[] A = new int[n+1];
        long[] d = new long[n+1];
        
        for(int i=0; i<n; i++){
            A[i+1] = Integer.parseInt(str[i]);
        }
        
        d[0] =1; // 이게 없으면 안됨 
        //이거 때문에 애먹었음... 백준에서 주어지는 입력값 중에 시작이 0으로 입력도 있나봄... 혹시 나 해서 이코드를 넣었더니 2부터 반복문을 시작해도 돌아간다.
        if(A[1]==0){
          d[1] =0;
        }
        else
          d[1] = 1;
        for(int i=2; i<=n; i++){
            if(A[i]>=1 && A[i]<=9){
                d[i] += d[i-1];
                d[i] %= 1000000;
            }
            //if(i==1) continue;
            if(A[i-1]<1) continue;
            int x = A[i-1]*10 + A[i];
            if(x>=10 && x<=26){
                d[i] += d[i-2]; //d[0]=1 이 아니면 여기서 d[0] =0으로 더해버림
                d[i] %= 1000000;
            }
        }
        
        System.out.println(d[n]%1000000);
    }
}
