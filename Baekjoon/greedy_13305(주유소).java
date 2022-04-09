//최적화 풀이 
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //각 도시의 리터당 가격
        int[] fuel = new int[n];
        //거리
        int[] dis = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n-1; i++){
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            fuel[i] = Integer.parseInt(st.nextToken());
        }

        long answer=0;
        long min = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++){  
            min = Math.min(min, fuel[i]); //굳이 먼저 뒤의 노드를 파악하지 않고 앞전 노드가 최소값이라면 기억해 놨다가 이 값으로 계속 계산하면됨 
            answer += (min*dis[i]);
        }
        System.out.println(answer);
    }
}
/*

//내풀이
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //각 도시의 리터당 가격
        int[] city = new int[n];
        //거리
        int[] dis = new int[n];
        boolean visited[] = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        dis[0] =0;
        for(int i=1; i<n; i++){
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        //city[i]의 범위가 1억 이하이므로 1억일때 3이상이면 int 범위 초과 -> long 형을 써야함
        long answer=0;
        //담번 노드들이 자기보다 크다면 거리들을 계속 플러스해서 해당 리터의 기름을 사고
        //다음 노드가 자신보다 작다면 다음 노드까지거리의 기름만 산다.
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            int cur = city[i];
            long disSum = 0;
            for(int j=i+1; j<n; j++){  //어차피 n-1번째는 도착지라 기름을 살 수 없음
                if(j==n-1){
                    disSum += dis[j];
                    visited[j] = true;
                }
                else if(cur > city[j]){ //다음 도시가 현재보다 기름값이 적다면
                    disSum += dis[j];
                    break;
                }
                else{
                    visited[j] = true;
                    disSum += dis[j];
                }
            }
            answer += (disSum * city[i]);
        }

        System.out.println(answer);
    }
}
*/
