import java.io.*;
import java.util.*;

class Main{
    static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] str2 = br.readLine().split(" ");

        A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(A);

        for(int i=0; i<m; i++){
            System.out.println(binarySearch(Integer.parseInt(str2[i]), n-1));
        }
    }
    public static int binarySearch(int num, int n){
        int left=0;
        int right=n;
        while(left<=right){
            int mid = (left+ right) /2;

            if(A[mid] > num){
                right = mid - 1;
            }
            else if(num > A[mid]){
                left = mid+1;
            }
            else
                return 1;
        }

        return 0;
    }
}
