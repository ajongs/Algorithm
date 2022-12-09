import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);

        System.out.println(pow(A, B, C));

    }
    public static long pow(long base, long expo, long C) {
        if (expo == 1) {
            return base % C;
        }

        long temp = pow(base, expo / 2, C);

        if (expo % 2 == 1) {
            return temp * temp % C * base % C;
        }
        return temp * temp % C;
    }
}
