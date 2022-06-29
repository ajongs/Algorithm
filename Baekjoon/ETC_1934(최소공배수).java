import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            int n1 = Integer.parseInt(str[0]);
            int n2 = Integer.parseInt(str[1]);

            int max = euclidean(n1,n2);
            n1/= max;
            n2 /= max;
            System.out.println(max*n1*n2);
        }
    }
    static int euclidean(int n1, int n2){
        if(n1 > n2){
            if(n1%n2==0){
                return n2;
            }
            else{
                return euclidean(n1%n2, n2);
            }
        }
        else{
            if(n2%n1==0){
                return n1;
            }
            else{
                return euclidean(n1, n2%n1);
            }
        }
    }
}
