import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 접시 수
        int d = Integer.parseInt(str[1]); // 초밥 가짓수
        int k = Integer.parseInt(str[2]); // 연속해서 먹는 수
        int c = Integer.parseInt(str[3]); // 쿠폰 번호
        int[] map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        int[] visited = new int[d+1];
        int start=0;
        visited[map[start]] =1;
        int end =1;
        int answer = Integer.MIN_VALUE;
        int cnt=1;
        while(end<=n+(k-2)){
           // System.out.println("end = " + end);

            if(end - start <= k-1){
                //ystem.out.println("(end-start) = " + (end-start));
                int type = map[end%n];
                if(visited[type]==0)
                    cnt++;
                visited[type]++;
                if(end - start == k-1){
                    if(visited[c]==0)
                        answer = Math.max(answer , cnt+1);
                    else
                        answer = Math.max(answer , cnt);
                }
                end++;

            }

            else{
                if(--visited[map[start++]] == 0){
                    cnt--;
                }

            }
            /*
            System.out.println("cnt = " + cnt);
            for(int i=1; i<d+1; i++){
                System.out.print(visited[i] +" ");
            }
            System.out.println();*/
        }
        System.out.println(answer);
        //기본 로직
        //연속해서 먹어보고 몇가지 먹었는지 체크 하고
        // + 쿠폰번호 한거가 최대값 갱신


    }
}
