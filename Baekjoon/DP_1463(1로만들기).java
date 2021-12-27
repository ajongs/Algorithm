import java.io.*;

class Main{
    static int d[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        
        System.out.println(makeOne(n));
    }
    public static int makeOne(int n){
        if(n==1) return 0;
        if(d[n]>0) return d[n];
        d[n] = makeOne(n-1)+1;
        if(n%2==0){
            int temp = makeOne(n/2) +1;
            if(d[n] > temp) d[n] = temp;
        }
        if(n%3==0){
            int temp = makeOne(n/3) +1;
            if(d[n] > temp) d[n]=temp;
        }
        return d[n];
    }
}
