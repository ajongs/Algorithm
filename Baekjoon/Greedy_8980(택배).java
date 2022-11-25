import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_8980 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int m = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[m];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int source = Integer.parseInt(input[0]);
            int destination = Integer.parseInt(input[1]);
            int box = Integer.parseInt(input[2]);

            nodes[i] = new Node(source, destination, box);
        }
        Arrays.sort(nodes);
        int answer = 0;
        int[] distance = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[i] = c;
        }
        for (int i = 0; i < m; i++) {
            Node node = nodes[i];

            int min = Integer.MAX_VALUE;
            for (int j = node.source; j < node.destination; j++) {
                min = Math.min(min, distance[j]);
            }
            int diff = min - node.box >= 0 ? node.box : min;
            if (diff == 0) continue;
            answer += diff;
            for (int j = node.source; j < node.destination; j++) {
                //만약 box가 해당 distance 보다 작다면 적게 태워야지
                distance[j] -= diff;
            }
        }
        System.out.println(answer);
    }
    static class Node implements Comparable<Node>{
        int source;
        int destination;
        int box;

        public Node(int source, int destination, int box) {
            this.source = source;
            this.destination = destination;
            this.box = box;
        }

        @Override
        public int compareTo(Node o) {
            if (this.destination == o.destination) {
                return this.source - o.source;
            }
            return this.destination - o.destination;
        }
    }
}
