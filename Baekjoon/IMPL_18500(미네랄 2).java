import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int r;
    static int c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<int[]> cluster = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();

            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int n = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(input[i]);
            visited = new boolean[r][c];
            fight(convertIndex(cur), i);
            visitedClusterOnTheGround();
            findClusterInTheAir();
            down();
        }

        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
    public static void fight(int row, int order) {
        if (order % 2 == 0) {
            //왼쪽에서 오른쪽으로
            for (int i = 0; i < c; i++) {
                if (map[row][i] == '.') continue;
                map[row][i] = '.';
                break;
            }
        }
        else {
            for (int i = c - 1; i > -1; i--) {
                if (map[row][i] == '.') continue;
                map[row][i] = '.';
                break;
            }
        }

    }
    public static int convertIndex(int cur) {
        return r - cur;
    }
    public static void visitedClusterOnTheGround() {
        for (int i = 0; i < c; i++) {
            if(visited[r-1][i] || map[r-1][i] == '.') continue;
            bfs(r-1, i);
        }
    }
    public static void findClusterInTheAir() {
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j] || map[i][j] == '.') continue;
                bfs(i, j);
                return;
            }
        }
    }
    public static void bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        visited[sr][sc] = true;
        cluster.clear();
        int[] start = new int[] {sr, sc};
        cluster.add(start);
        q.offer(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nr][nc] || map[nr][nc] == '.') continue;
                visited[nr][nc] = true;
                int[] next = new int[] {nr, nc};
                cluster.add(next);
                q.offer(next);
            }

        }
    }
    public static void down() {
        //클러스터 중에 가장 아래 부분이 얼마나 차이 나는지
        //일단 클러스터 부분 map에서 .으로 변경
        airClusterInitInMap();
        //현재 클러스터 아래로 내려갈껀데 얼마까지 가능한지
        int count = getDownCount();
        // count 만큼 내려서 마킹
        for (int[] point : cluster) {
            map[point[0] + count][point[1]] = 'x';
        }
    }
    public static void airClusterInitInMap() {
        for (int[] point : cluster) {
            map[point[0]][point[1]] = '.';
        }
    }
    public static int getDownCount() {
        for (int i = 1; i < r; i++) {
            for (int[] point : cluster) {
                int nr = point[0] + i;
                int nc = point[1];

                if (nr >= r || map[nr][nc] == 'x') {
                    return i - 1;
                }
            }
        }
        return 0;
    }
}
