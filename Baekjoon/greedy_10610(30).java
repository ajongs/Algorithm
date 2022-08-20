import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //3의 배수인지? 판별
        //10^5 자리의 수는 int, long을 넘음
        int[] nums = new int[10];
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i)-'0';
            nums[num]++;
        }

        //0을 포함하는지 판별
        if(nums[0]==0){
            System.out.println(-1);
            return;
        }
        int isPossible=0;
        for(int i=0; i<10; i++){
            isPossible += nums[i] * i; //개수 x 해당숫자
        }
        //3의 배수인지 판별
        if(isPossible%3 !=0) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=9; i>=0; i--){
            if(nums[i]>0){
                for(int j=0; j<nums[i]; j++){
                    sb.append(i);
                }
            }
        }
        System.out.println(sb);
    }
}
