import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split("");

            Stack<String> stack = new Stack<>();
            for(int j=0; j<str.length; j++){
                if(str[j].equals(")")){
                    if(stack.isEmpty()){
                        stack.push(str[j]);
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else{
                    stack.push(str[j]);
                }
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
