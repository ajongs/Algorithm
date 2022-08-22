import java.io.*;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            q.offer(Integer.parseInt(br.readLine()));
        }
        int result =0;
        while(!q.isEmpty()){
            int cur = q.poll();

            int next=0;
            if(!q.isEmpty()){
                next = q.poll();
                result += cur+next;
                q.offer(cur+next);
            }
            else{
                System.out.println(result);
            }
        }
    }
}
