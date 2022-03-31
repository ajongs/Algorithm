import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    static int n;
    static int m;
    static int start;
    static int end;
    static boolean[] visited;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]); //
        m = Integer.parseInt(str[1]); //
        list = new ArrayList[n+1];

        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }


        int max = 0;
        for(int i=0; i<m; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);
            list[a].add(new Node(b,w));
            list[b].add(new Node(a,w));
            max = Math.max(max, w);
        }



        str = br.readLine().split(" ");
        start = Integer.parseInt(str[0]);
        end = Integer.parseInt(str[1]);

        int left =1;
        int right = max;

        while(left <= right){
            int mid = (left+right)/2;

            if(bfs(mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(right);

        br.close();
    }
    public static boolean bfs(int mid){
        visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur==end){
                return true;
            }

            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i).next;
                if(!visited[next] && list[cur].get(i).weight >= mid){
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }

        return false;
    }
    static class Node{
        int next;
        int weight;
        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }
    }
}
