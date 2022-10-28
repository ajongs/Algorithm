import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static ArrayList<Integer> nums;
    static ArrayList<Character> ops;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        nums = new ArrayList<>();
        ops = new ArrayList<>();

        String numStr = str.replaceAll("[^0-9]", "");
        String opStr = str.replaceAll("[0-9]","");
        for(int i=0; i<numStr.length(); i++){
            nums.add(numStr.charAt(i)-'0');
        }
        for(int i=0; i<opStr.length(); i++){
            ops.add(opStr.charAt(i));
        }
        int[][] min = new int[n/2+1][n/2+1];
        int[][] max = new int[n/2+1][n/2+1];
        for(int i=0; i<n/2+1; i++){
            for(int j=0; j<n/2+1; j++){
                min[i][j] = Integer.MAX_VALUE;
                max[i][j] = Integer.MIN_VALUE;
            }
        }
        for(int i=0; i<=n/2; i++){
            max[i][i] = min[i][i] = nums.get(i);
        }
        for(int j=1; j<n/2+1; j++){
            for(int i=0; i<(n/2+1) -j ; i++){
                for(int k=0; k<j; k++){
                    int[] temp = new int[4];
                    temp[0] = calc(max[i][i+k],max[i+k+1][i+j], ops.get(i+k));
                    temp[1] = calc(max[i][i+k],min[i+k+1][i+j], ops.get(i+k));
                    temp[2] = calc(min[i][i+k],max[i+k+1][i+j], ops.get(i+k));
                    temp[3] = calc(min[i][i+k],min[i+k+1][i+j], ops.get(i+k));

                    Arrays.sort(temp);

                    min[i][i+j] = Math.min(min[i][i+j], temp[0]);
                    max[i][i+j] = Math.max(max[i][i+j], temp[3]);
                }
            }
        }
        System.out.println(max[0][n/2]);
       
    }
    public static int calc(int n1, int n2, char op){
        if(op == '+'){
            return n1 + n2;
        }else if(op == '*'){
            return n1 * n2;
        }
        else{
            return n1 - n2;
        }
    }
    public static void dfs(int result, int opIdx){
        if(opIdx >= ops.size()){
            max = Math.max(result, max);
            return;
        }

        //이전 결과값에 더하기
        int res1 = calc(result, nums.get(opIdx+1), ops.get(opIdx));
        dfs(res1, opIdx+1);

        if(opIdx+1 < ops.size()){
            int res3 = calc(nums.get(opIdx+1), nums.get(opIdx+2), ops.get(opIdx+1));
            int res2 = calc(result, res3, ops.get(opIdx));
            dfs(res2, opIdx+2);
        }
    }
}
