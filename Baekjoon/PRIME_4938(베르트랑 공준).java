import java.io.*;

class test{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) return;
            int answer =0;
            for(int i=n+1; i<=2*n; i++){
                if(eratosthenes(i)){
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
    static boolean eratosthenes(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
