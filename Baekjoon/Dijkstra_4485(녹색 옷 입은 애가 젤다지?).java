
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(row[j]);
                }
            }

            int answer = dijkstra(n, map);

            bw.write("Problem " + cnt++ + ": " + answer + "\n");
        }
        bw.flush();
    }

    public static int dijkstra(int n, int[][] map) {
        Queue<Node> pq = new PriorityQueue();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int[][] dis = new int[n][n];
        for (int[] di : dis) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }
        pq.offer(new Node(0, 0, map[0][0]));
        dis[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int nowDis = now.dis;
            int r = now.r;
            int c = now.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int cost = dis[r][c] + map[nr][nc];
                if (cost < dis[nr][nc]) {
                    dis[nr][nc] = cost;
                    pq.offer(new Node(nr, nc, cost));
                }
            }
        }
        return dis[n - 1][n - 1];
    }
}

class Node implements Comparable<Node> {
    int r;
    int c;
    int dis;

    public Node(int r, int c, int dis) {
        this.r = r;
        this.c = c;
        this.dis = dis;
    }

    @Override
    public int compareTo(Node o) {
        return this.dis - o.dis;
    }
}
