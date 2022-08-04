import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        // (sum[i] - sum[j]) % m = 0 을
        // sum[i]%m - sum[j]%m = 0 분배법칙 사용가능
        // sum[i]%m = sum[j]%m , 결국 i까지의 부분합의 나머지, j까지의 부분합의 나머지가 같은 경우를 찾아주면 된다
        // mod 에 나머지값이 같은 sum의 i 값들의 개수를 저장
        // 그 중 순서 상관없이 2개 뽑는 경우의 수 고려 (조합)
        // n!/ (n-2)!2!  = n(n-1)/2
        // 예외. sum[i]%m 가 0일때는 자신(혼자)의 구간에서도 만족 (i==j) 
        // ex) sum[2] = (1+2+3)% 3 =  6 % 3 = 0
        // 따라서 mod[0] 의 갯수를 먼저 답에 추가함
        int[] mod = new int[m];
        int sum=0;
        for(int i=0; i<n; i++){
            sum += Integer.parseInt(str[i]) %m;
            mod[sum%m]++;
        }

        long answer=mod[0];
        for(int i=0; i<m; i++){
            int cnt = mod[i];
            answer += (long)cnt*(cnt-1) /2;
        }

        System.out.println(answer);
    }
}

//Resolve
/*
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        //(sum[i] - sum[j]) % m = 0
        //(sum[i]%m) - sum[j]%m = 0;
        // sum[i]%m = sum[j]%m;
        int[] count = new int[m];
        int sum=0;
        for(int i=0; i<n; i++){
            sum += Integer.parseInt(str[i])%m;
            count[sum%m]++;
        }
        //0번째는 혼자서도 나누어 떨어지므로 짝을 이룰 필요가 없음
        //따라서 먼저 더하기
        long answer = count[0];

        for(int i=0; i<m; i++){ //sum[i]와 sum[j]가 같은 부분을 찾아야함
            // (i,j) 쌍이 항상 i<=j를 만족하는 경우의 수는 count에 있는 나머지값들로 2개 뽑기(조합)
            //조합 공식은 n!/(n-r!)r! 여기서 r=2 이므로 n!/(n-2)!2! => n(n-1)/2 로 줄일 수 있음
            int num = count[i];
            answer += (long)num*(num-1)/2;
        }

        System.out.println(answer);
    }
}
*/
