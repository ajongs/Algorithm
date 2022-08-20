import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        int count=0;
        while(b>a){
            if(b%2==0){
                b/=2;
                count++;
            }
            else if(b%10 ==1){
                b/=10;
                count++;
            }
            else{
                System.out.println(-1);
                return;
            }
        }
        if(b!=a){
            System.out.println(-1);
            return;
        }
        System.out.println(++count);

    }
}
