import java.io.*;

class Main{
    static int d[] = new int[11];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n[] = new int[T];
        for(int i=0; i<T; i++){
            n[i] = Integer.parseInt(br.readLine());
            System.out.println(addOneTwoThree(n[i]));
        }
        
    }
    public static int addOneTwoThree(int n){
        d[0]=1;
        d[1]=1;
        d[2]=2;
        for(int i=3; i<=n; i++){
          d[i] = d[i-1]+ d[i-2] + d[i-3];
        }
        return d[n];
    }
}
