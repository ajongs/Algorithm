import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int P = 1_000_000;
    static final int PERIOD = 15 * (P / 10);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int[] fibo = new int[PERIOD];
        //파사노 주기 활용
        //나누는 수 P = 10^k (k>2) 일 때, 주기 : 15 * 10^(k-1)
        //ex) P = 10^6, 주기 : 15 * 10^5
        int index = getIndex(n);
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < PERIOD; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % P;
        }
        System.out.println(fibo[index]);
    }
    public static int getIndex(long n) {
        return (int)(n % PERIOD);
    }
}
