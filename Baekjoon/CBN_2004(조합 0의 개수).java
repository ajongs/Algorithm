import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        long cnt_2 = count2(n) - count2(n-m) - count2(m);
        long cnt_5 = count5(n) - count5(n-m) - count5(m);

        System.out.println(Math.min(cnt_2, cnt_5));
    }
    static long count2(int n){
        long num=0;
        for(long i=2; i<=n; i*=2){
            num += n/i;
        }
        return num;
    }
    static long count5(int n){
        long num =0;
        
        for(long i=5; i<=n; i*=5){
            num += n/i;
        }
        return num;
    }
}
