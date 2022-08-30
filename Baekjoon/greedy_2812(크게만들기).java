import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        str = br.readLine().split("");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(arr[o1]==arr[o2]){
                    return o1-o2;
                }
                return arr[o2] - arr[o1];
            }
        });
        //시작? 부터 n-(n-k) 포함까지 큐에 넣으면 됨.
        for(int i=0; i<=n-(n-k); i++){
            pq.offer(i);
        }
        int index=n-(n-k);
        int lastIndex=0;
        int count=0;
        StringBuilder sb = new StringBuilder();
        while(count < n-k){
            int cur = pq.poll();
            //System.out.println("cur = " + cur);;
            if(lastIndex > cur){
                continue;
            }
            //적합할때는
            sb.append(arr[cur]);
            lastIndex = cur;
            count++;
            if(++index < n){
                pq.offer(index);
            }
        }
        System.out.println(sb);
    }
}
