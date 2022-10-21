import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int s=0;
        int e=1;
        int answer= Integer.MAX_VALUE;
        while(s<=e&& e < arr.length){
            int diff = arr[e]-arr[s];
            if(diff >= m){
                answer = Math.min(answer, diff);
                s++;
                //만약 둘 차이가 4야
                //그럼 s를 올려보자
                //일단 정답이 될 수 도있으니 정답 초기화
            }else{ //diff < m
                e++;
            }
        }
        System.out.println(answer);
    }
}
