import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] array = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(str[i]);
        }
        
        for(int i=1; i<n; i++){
            int gcd;
            if(array[0] < array[i]){
                gcd = euclidean(array[0], array[i]);
            }
            else{
                gcd = euclidean(array[i], array[0]);
            }
            System.out.println(array[0]/gcd+"/"+array[i]/gcd);
        }
    }
    static int euclidean(int a, int b){
        if(a == 0){
            return b;
        }
        else 
            return euclidean(b%a, a);
    }
}
