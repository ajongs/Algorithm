import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());
        long sum=0;
        long n=0;
        for(long i=1; ; i++){
            if(sum > s){
                n--;
                break;
            }
            else if(sum ==s){
                break;
            }
            sum += i;
            n++;
        }
        System.out.println(n);
    }
}
