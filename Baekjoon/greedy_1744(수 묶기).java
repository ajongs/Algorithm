import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minus = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                plus.add(num);
            }
            else{
                minus.add(num);
            }
        }
        int result=0;
        while(!plus.isEmpty()){
            int cur = plus.poll();

            if(!plus.isEmpty()){
                int next = plus.poll();
                cur = Math.max(cur+next, cur*next);
            }
            result += cur;
        }
        while(!minus.isEmpty()){
            int cur = minus.poll();

            if(!minus.isEmpty()){
                int next = minus.poll();
                cur = cur*next;
            }
            result += cur;
        }
        System.out.println(result);
    }
}
