import java.io.*;

class Main{
    static int n;
    static int k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]); //나열될 숫자
        k = Integer.parseInt(str[1]); //숫자 위치

        if(calc(n) < k){
            System.out.println(-1);
            return;
        }
        int left =1;
        int right=n;

        int pos=0;
        while(left<=right){
            int mid = (left+right)/2;

            int num= calc(mid);
            if(num >= k){
                right = mid - 1;
                pos = mid;
            }
            else{
                left = mid + 1;
            }
        }

        int len = calc(pos);


        String[] ans = Integer.toString(pos).split("");

        System.out.println(ans[ans.length - (len - k) - 1]);

        br.close();
    }
    public static int calc(int mid){
        int len=1;
        int num=0;
        for(int i=1; i<=mid; i*=10){

            int end = i*10-1;
            if(end > mid){
                end = mid;
            }
            num += (end - i + 1) * len;
            len++;
        }
        return num;
    }
}
