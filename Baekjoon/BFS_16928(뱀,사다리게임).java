import java.io.*;
import java.util.*;

class Main{
    static int[] next = new int[101];
    static int[] dist = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        for(int i=1; i<=100; i++){
            next[i] = i;
            dist[i] = -1;
        }
        int n = Integer.parseInt(str[0]); //사다리수
        int m = Integer.parseInt(str[1]); //뱀의 수

        for(int i=0; i<n+m; i++){
            String[] vertex = br.readLine().split(" ");
            int x = Integer.parseInt(vertex[0]);
            int y = Integer.parseInt(vertex[1]);
            next[x] = y;
        }

        dist[1]=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=1; i<7; i++){
                int y = x+i;
                if(y > 100) continue;
                if(dist[next[y]] == -1){
                    q.offer(next[y]);
                    dist[next[y]] = dist[x] + 1;
                }

            }
        }

        System.out.println(dist[100]);
    }
}
