import java.io.*;
import java.util.*;
class Main{
    static int n;
    static int m;
    static int[] dist;
    static int[] dx = {1, -1};
    final static int INF = 100001; //최대 거리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        dist = new int[INF];

        for(int i=0; i<INF; i++){
            dist[i] = INF;
        }
        dijkstra(n); //수빈이의 첫 위치가 시작점

        System.out.println(dist[m]);
    }
    static void dijkstra(int start){
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        dist[start] =0;
        while(!q.isEmpty()){
            Node curNode = q.poll();
            int curPoint = curNode.point;
            int curTime = curNode.time;

            //도착한 포인트의 curTime이 이미 저장된 dist[curPoint] 보다작은 경우
            if(dist[curPoint] < curTime) continue;

            //갈 수 있는 경우의 수 두개 체크
            for(int i=0; i<2; i++){
                int workPoint = curPoint + dx[i];
                int workTime = 1;

                if(workPoint >=0 && workPoint <INF){
                    if(dist[workPoint] > curTime + workTime){
                        dist[workPoint] = curTime + workTime;
                        q.offer(new Node(workPoint, dist[workPoint]));
                        //System.out.println("workPoint = " + workPoint);
                    }
                }
            }

            //순간이동 하는 경우
            int jumpPoint = curPoint * 2;
            if(jumpPoint >=0 && jumpPoint <INF) {
                if(dist[jumpPoint] > curTime){
                    dist[jumpPoint] = curTime;
                    q.offer(new Node(jumpPoint, dist[jumpPoint]));
                    //System.out.println("jumpPoint = " + jumpPoint);
                }
            }

        }

    }
    static class Node implements Comparable<Node>{
        int point;
        int time;

        public Node(int point, int time){
            this.point = point;
            this.time = time;
        }

        @Override
        public int compareTo(Node o1){
            if(this.time == o1.time)
                return this.point - this.point;
            return this.time - o1.time;
        }
    }
}
