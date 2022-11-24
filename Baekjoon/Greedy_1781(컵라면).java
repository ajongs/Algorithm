import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1781 {
    static int maxDeadLine = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int deadLine = Integer.parseInt(input[0]);
            int ramen = Integer.parseInt(input[1]);
            maxDeadLine = Math.max(maxDeadLine, deadLine);
            List<Integer> list = map.getOrDefault(deadLine, new ArrayList<>());
            list.add(ramen);
            map.put(deadLine, list);
        }

        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = maxDeadLine; i > 0; i--) {
            if (map.containsKey(i)) {
                pq.addAll(map.get(i));
            }
            if (pq.isEmpty()) continue;
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}

