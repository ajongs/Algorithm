import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long P = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        long A = factorial(n);
        long B = factorial(k) * factorial(n-k) % P;

        System.out.println(A * pow(B, P-2) % P);
    }
    public static long factorial(int num) {
        long answer = 1;
        while (num > 1) {
            answer = (answer * num) % P;
            num--;
        }
        return answer;
    }
    public static long pow(long B, long n) {
        if (n == 1) {
            return B;
        }

        long temp = pow(B, n/2);

        if (n % 2 == 1) {
            return (temp * temp) % P * B % P;
        }
        return temp * temp % P;
    }
}
