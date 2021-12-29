import java.io.*;

class Main{
    static int d[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //n+1 하는 이유는 n까지 인덱스를 사용하기 위해서
        d = new int[1001];
        d[1] = 1;
        d[2] = 2;
        System.out.println(countMethod(n));
    }
    public static int countMethod(int n){
        if(n>2){
            for(int i=3; i<=n; i++){
                d[i] = d[i-1] + d[i-2];
                d[i] %= 10007;
            }
        }
        return d[n];
    }
}
