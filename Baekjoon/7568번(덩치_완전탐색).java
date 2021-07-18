import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<int[]> arr = new ArrayList<int[]>();
        int[] result = new int[N];
        for(int i=0; i<N; i++){
            String[] st = br.readLine().split(" ");
            
            int[] temp = {Integer.parseInt(st[0]), Integer.parseInt(st[1])};
            arr.add(temp);
            result[i] = 1;
        }
        
        
        for(int i=0; i<N; i++){
            int[] temp = arr.get(i);
            for(int j=0; j<N; j++){
                if(temp[0]<arr.get(j)[0] && temp[1]<arr.get(j)[1]){
                    result[i]++;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(result[i]+" ");
        }
    }
}
