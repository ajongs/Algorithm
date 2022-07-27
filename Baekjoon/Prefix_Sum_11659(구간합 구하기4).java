import java.io.*;
//부분합 문제는 미리 계산을 다 해놓고 dp 처럼 가져다가 시작과 끝 인덱스까지 합을 빼는 것으로 구함
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] arr = new int[n+1];

        str = br.readLine().split(" ");
        for(int i=0; i<str.length; i++){
            arr[i+1] = arr[i] + Integer.parseInt(str[i]);
        }

        for(int i=0; i<m; i++){
            str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);

            System.out.println(arr[end]- arr[start-1]);
        }
    }
}
