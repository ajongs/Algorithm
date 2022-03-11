import java.util.*;
class Solution {
    int[] group;
    int network=0;
    public int solution(int n, int[][] computers) {
        group = new int[n];

        for(int i=0; i<n; i++){
            bfs(n, i, computers);
        }

        return network;
    }
    public void bfs(int n, int index, int[][] computers) {

        Queue<Integer> q = new LinkedList<>();
        if (group[index] == 0) {
            network++;
            q.offer(index);
            group[index] = network;
        }
        while (!q.isEmpty()) {
            int cIndex = q.poll();

            for (int i = 0; i < n; i++) {
                if (cIndex == i)
                    continue;
                if (computers[cIndex][i] == 1 && group[i] == 0) {
                    group[i] = network;
                    q.offer(i);
                }
            }
        }
    }
}
