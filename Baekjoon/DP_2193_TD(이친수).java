import java.io.*;

class Main{
    static long[] d;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new long[n+1];
        
        System.out.println(pinaryNum(n));
    }
    public static long pinaryNum(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        if(d[n]>0){
            return d[n];
        }
        // n번째 자리에 올 수 있는 수 0,1
        // 1. 0이 올때 n-1번째 자리에 0/1 둘다 올 수 있으므로 n-1 자리로 만들 수 있는 수에 0만 더해주면됌
        // 2. 1이 올때 n-1번째 자리에 0만 올수 있고 n-2자리엔 0/1둘다 올 수 있으므로 n-2 자리로 만들 수 있는 이친수에 01 을 더해주면됌.
        // 따라서, n번째자리로 만들 수 있는 이친수 개수 = n-1 번째 자리로 만들 수 있는 이친수 개수 + n-2 번째 자리로 만들 수 있는 이친수 개수
        
        d[n] = pinaryNum(n-1) + pinaryNum(n-2);
        return d[n];
    }
    
}
