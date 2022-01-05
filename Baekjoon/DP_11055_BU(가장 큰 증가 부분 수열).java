import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        
        int[] d = new int[n+1];
        int[] A = new int[n+1];
        int answer = 0;
        
        for(int i=1; i<n+1; i++){
            A[i] = Integer.parseInt(str[i-1]);        
        }   
        
        for(int i=1; i<n+1; i++){
            d[i] = A[i];
            for(int j=1; j<i; j++){
                if(A[i]>A[j] && d[i]<d[j]+A[i])
                    d[i] = d[j]+A[i];
            }
        }
        for(int i=1; i<n+1; i++){
            if(answer < d[i])
                answer = d[i];
        }
        System.out.println(answer);
    } 
}
