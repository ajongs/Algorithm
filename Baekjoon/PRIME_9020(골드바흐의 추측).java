import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //일단 수를 반절로 나누고
        //계속 검사하면서 두수가 소수인지 체크
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int n1 = n/2;
            int n2 = n - n1;
            while(n1>1 || n2<=n){
                if(eratosthenes(n1) && eratosthenes(n2)){
                    if(n1==n2){
                        System.out.println(n1+" "+n1);
                        break;
                    }
                    System.out.println(Math.min(n1,n2)+" "+Math.max(n1,n2));
                    break;
                }
                else{
                    n1--;
                    n2++;
                }
            }
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
