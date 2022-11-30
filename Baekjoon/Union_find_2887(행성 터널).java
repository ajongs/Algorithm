import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        Vertex[] vertex = new Vertex[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);

            vertex[i] = new Vertex(i, x, y, z);
            parent[i] = i;
        }

        List<Edge> edgeList = new ArrayList<>();
        //x에 대해서 정렬
        Arrays.sort(vertex, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.x - o2.x;
            }
        });
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(vertex[i].x - vertex[i + 1].x);
            edgeList.add(new Edge(vertex[i].num, vertex[i + 1].num, weight));
        }
        //y에 대해서 정렬
        Arrays.sort(vertex, (o1, o2) -> o1.y - o2.y);
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(vertex[i].y - vertex[i + 1].y);
            edgeList.add(new Edge(vertex[i].num, vertex[i + 1].num, weight));
        }
        Arrays.sort(vertex, (o1, o2) -> o1.z - o2.z);
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(vertex[i].z - vertex[i + 1].z);
            edgeList.add(new Edge(vertex[i].num, vertex[i + 1].num, weight));
        }

        Collections.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);

        int minWeight = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            //e를 v로 이음
            Edge edge = edgeList.get(i);

            if (find(edge.e) != find(edge.v)) {
                union(edge.e, edge.v);
                minWeight += edge.weight;
            }
        }
        System.out.println(minWeight);

    }
    static void union(int a, int b) {
        //a 가 작은 것
        a = find(a);
        b = find(b);

        if (a == b) return;
        parent[b] = a;
    }
    static int find(int num) {
        //a가 더 작은 것
        if (parent[num] == num) {
            return num;
        }
        return parent[num] = find(parent[num]);
    }
    static class Vertex{
        int num;
        int x;
        int y;
        int z;

        public Vertex(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Edge{
        int v;
        int e;
        int weight;

        public Edge(int v, int e, int weight) {
            this.v = v;
            this.e = e;
            this.weight = weight;
        }
    }
}
