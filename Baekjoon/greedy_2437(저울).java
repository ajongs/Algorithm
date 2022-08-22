import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        //1 1 2 3 6 7 30
        int sum=0;
        for(int i=0; i<n; i++){
            if(sum+1 < arr[i]){
                break;
            }
            sum+= arr[i];
        }
        System.out.println(sum+1);
        //프린트가 for문안 if문에 있으면 안됌. 
        //if문에 걸리지 않으면 출력하지않음
        //예를들어 모든 인덱스를 다 통과하면 다음 인덱스가 없으므로 
        //if문이 걸리지 않음
        //그런 경우 출력을 안하게되어 틀림처리가됨. 주의.
    }
}
