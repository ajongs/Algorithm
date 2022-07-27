import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        //슬라이딩 윈도우
        int sum=0;

        for(int i=0; i<k; i++){
            sum+= Integer.parseInt(str[i]);
        }
        int max = sum;
        //풀이 1. 앞에서 부터 증가되는 인덱스 기준으로 구현
        for(int i=1; i<n-k+1; i++){
            sum -= Integer.parseInt(str[i-1]);
            sum += Integer.parseInt(str[i+k-1]);
            max = Math.max(max, sum);
        }
        //풀이2 새로 삽입되는 인덱스 기준으로 구현
        /*
        for(int i=0; i<n; i++){
            sum += Integer.parseInt(str[i]);
            if(i == k-1){
                max = sum;
            }
            if( i >= k){
                sum -= Integer.parseInt(str[i-k]);
                max = Math.max(max, sum);
            }
        }*/

        System.out.println(max);
    }
}
