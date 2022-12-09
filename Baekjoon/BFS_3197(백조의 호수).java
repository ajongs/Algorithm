import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int r;
    static int c;
    static boolean[][] visited;
    static Queue<int[]> waterQ;
    static Queue<int[]> q;
    static boolean[][] routeVisited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new char[r][c];
        routeVisited = new boolean[r][c];
        waterQ = new LinkedList<>();
        q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char cur = line.charAt(j);
                if (cur == 'L') {
                    list.add(new int[] {i, j});
                    cur = '.';
                }
                if (cur == '.') {
                    waterQ.offer(new int[] {i, j});
                }
                map[i][j] = cur;
            }
        }

        int answer = 0;
        int[] start = list.get(0);
        int[] end = list.get(1);
        q.offer(start);
        routeVisited[start[0]][start[1]] = true;
        /*
        for (int i = 0; i < 3; i++) {
            visited = new boolean[r][c];
            bfs();
        }
        System.out.println(route(list));*/

        while (!route(end[0], end[1])) {
            melt();
            answer++;
        }
        System.out.println(answer);
        /*
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar+"");
            }
            System.out.println();
        }*/

    }
    public static boolean route(int endR, int endC) {
        Queue<int[]> nextQ = new LinkedList<>();

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == endR && cur[1] == endC) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (!rangeCheck(nr, nc) || routeVisited[nr][nc]) continue;

                routeVisited[nr][nc] = true;
                if (map[nr][nc] == 'X') {
                    nextQ.offer(new int[] {nr, nc});
                } else if (map[nr][nc] == '.')
                    q.offer(new int[] {nr, nc});
            }
        }
        q = nextQ;
        return false;
    }
    public static void melt() {
        int size = waterQ.size();

        while (size-- > 0) {
            int[] cur = waterQ.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (!rangeCheck(nr, nc) || map[nr][nc] != 'X') continue;
                map[nr][nc] = '.';
                waterQ.add(new int[] {nr, nc});
            }
        }
    }
    public static boolean rangeCheck(int nr, int nc) {
        if (nr < 0 || nr >= r || nc < 0 || nc >= c) return false;
        return true;
    }
}
