import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n;
        int[] d;
        for(int i=0; i<t; i++){
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            d = new int[n];
            for(int j=0; j<n; j++){
                d[j] = Integer.parseInt(str[j+1]);
            }
            System.out.println(sumGcd(d,n));
        }
    }
    public static long sumGcd(int[] d, int n){
        long sum=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                sum += gcd(d[i], d[j]);
            }
        }
        return sum;
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
}
