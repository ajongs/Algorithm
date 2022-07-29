import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int idx=1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());


            while(stack.isEmpty()|| idx<=num){
                stack.push(idx++);
                sb.append('+').append('\n');
            }

            int pop = stack.pop();
            if(pop == num){
                sb.append('-').append('\n');

            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
