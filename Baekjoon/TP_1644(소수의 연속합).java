import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //n 전까지 소수를 구하고
        boolean[] isNotPrime = new boolean[n+1];
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i=2; i*i<=n; i++){
            if(!isNotPrime[i]){
                for(int j=i; i*j<=n; j++){
                    isNotPrime[i*j] = true;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            if(!isNotPrime[i])
                list.add(i);
        }
        list.add(0);

        int start=0;
        int end=0;
        int sum=0;
        int cnt=0;
        int size = list.size();
        while(end<size){
            if(sum == n){
                cnt++;
                sum += list.get(end++);
                sum -= list.get(start++);
            }else if(sum < n){
                sum += list.get(end++);
            }else{
                sum -= list.get(start++);
            }
        }
        System.out.println(cnt);
    }
}
