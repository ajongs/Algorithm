import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(str1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] str2 = br.readLine().split(" ");
        int[] b = new int[m];
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(a);

        for(int i=0; i<m; i++){
            int left=0;
            int right=n-1; //이분탐색할때 제발 배열 크기생각하자...
            int low=0;
            int upper=0;
            while(left <= right){
                int mid = (left + right) /2;
                if(a[mid]==b[i]){
                    low = mid;
                    right = mid -1;
                }
                else if(a[mid] > b[i]){
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
            left=0;
            right = n-1;
            while(left <= right){
                int mid = (left + right) /2;
                if(a[mid]==b[i]){
                    upper = mid+1;
                    left = mid+1;
                }
                else if(a[mid] > b[i]){
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
            bw.append(upper-low+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
