import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);

        int[] dis = new int[n];
        for(int i=0; i<n; i++){
            dis[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dis);
        int left=1;
        int right=dis[n-1];


        while(left <= right){
            int mid = (left + right)/2;
            //1 2 4 8 9
            int pre=0;
            int count=0;
            for(int i=0; i<n; i++){
                if(pre==0 || dis[i]- pre >= mid){
                    pre = dis[i];
                    count++;
                }
            }

            if(count>=c){
                left = mid +1;
            }
            else if(count <c){
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
