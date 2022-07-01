import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int r = Integer.parseInt(str[1]);

        //nCr
        int answer=1;
        for(int i=0; i<r; i++){
            answer *= n-i;
            answer /= i+1;
        }
        System.out.println(answer);
    }
}
