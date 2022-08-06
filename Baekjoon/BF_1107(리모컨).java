import java.io.*;
import java.util.Arrays;


class Main{
    static boolean[] remoteNum = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int cur = 100;
        int min = Integer.MAX_VALUE;
        Arrays.fill(remoteNum, true);
        if(m!=0){
            String[] str  = br.readLine().split(" ");
            for(int i=0; i<str.length; i++ ){
                int index = Integer.parseInt(str[i]);
                remoteNum[index] = false; //사용불가 처리
            }
        }
        int length = Integer.toString(n).length();
        //n 하나씩 돌면서 버튼 머누를지 체크
        for(int i=0; i<999999; i++){
            int count =0;
            boolean flag = true;
            String[] temp = Integer.toString(i).split("");

            for(int j=0; j<temp.length; j++){
                if(!remoteNum[Integer.parseInt(temp[j])]) {
                    flag = false;
                    break;
                }
                count++;
            }
            if(flag){
                if(n != i){
                    count += Math.abs(n-i);
                }
                min = Math.min(min, count);
            }
        }
        min = Math.min(min, Math.abs(n - cur));
        System.out.println(min);
    }
}
