import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Softeer_cluster {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        long B = Long.parseLong(str[1]);
        str = br.readLine().split(" ");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(a);
        long left = a[0];
        long right = a[N - 1] + (long)Math.sqrt(B);
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (calculate(mid, a, B)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean calculate(long min, int[] a, long B) {
        long cost = 0;
        for (int i : a) {
            if (i < min) {
                cost += (min - i) * (min - i);
                if (cost > B) return false;
            }
        }
        return true;
    }
}
