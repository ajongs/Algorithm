import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        //로프를 선택할 수도 있고 안할 수도있는게 어려운점
        //로프를 선택하는 경우
        //5 7 15 20
        //이럼 세개다 해도 15
        //15 20 하면 30
        //그럼 큰것부터 조사하면서 자기가 들어갔을때랑
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int idx=1;
        int result=0;
        for(int i=arr.length-1; i>=0; i--){
            if(result > arr[i]*idx){
                idx++;
                continue;
            }
            result = arr[i]*idx++;
        }
        System.out.println(result);
    }
}
