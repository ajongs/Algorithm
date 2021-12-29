import java.io.*;

class Main{
    static int d[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        System.out.println(countMethod(n));
    }
    public static int countMethod(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        d[n] = countMethod(n-1)+countMethod(n-2) % 10007;
        return d[n];
    }
}
