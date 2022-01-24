import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] st2 = br.readLine().split(" ");
        int[] str = new int[n];
        int[] str2 = new int[m];
        for(int i=0; i<n;i++){
            str[i] = Integer.parseInt(st[i]);

        }
        for(int i=0; i<m; i++){
            str2[i] = Integer.parseInt(st2[i]);
        }
        Arrays.sort(str);

        for(int i=0; i<m; i++){
            int l=0;
            int r=n-1;
            boolean flag=false;
            while(l<=r){
                int mid = (l+r)/2;
                if(str2[i] == (str[mid])){
                    flag = true;
                    break;
                }
                else if(str2[i] > str[mid]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }

            }
            if(flag) System.out.print(1+" ");
            else System.out.print(0+" ");
        }
    }

}
