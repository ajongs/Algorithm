import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), "+|-", true);
        //마이너스가 나오면 다음 마이너스가 나올때까지 계산하기
        int length = (st.countTokens()+1)/2;
        Boolean minusState = false;
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> ops = new ArrayList<>();
        ops.add("+");
        while(st.hasMoreTokens()){
            String next = st.nextToken();
            if(next.equals("+") || next.equals("-")){
                if(next.equals("+")){
                    ops.add("+");
                }
                else{
                    ops.add("-");
                }
            }
            else{
                nums.add(Integer.parseInt(next));
            }
        }
        int answer=0;
        for(int i=0; i<ops.size(); i++){
            if(ops.get(i).equals("-")){
                minusState = true;
            }
            if(minusState){
                answer -= nums.get(i);
            }
            else{
                answer += nums.get(i);
            }
        }

        System.out.println(answer);
    }
}
