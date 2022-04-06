import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] ability;
    static boolean[] visited;
    static int[] team1;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        visited = new boolean[n];
        team1 = new int[n/2];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                ability[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<n-1; i++){
            visited[i] = true;
            select(i,1);
            visited[i] = false;
        }
        System.out.println(min);
    }
    public static void select(int player, int count){
        team1[count-1] = player;
        if(count==n/2){
            //여기서 이제 방문하지 않은 플레이어들 싸그리 모아서 능력치 계산하고
            //지금까지 선택된 플레이어들의 능력치와 비교
            int team1Sum = team1Sum();
            int team2Sum = team2Sum();
            min = Math.min(min, Math.abs(team1Sum-team2Sum));
            return;
        }
        for(int i=player; i<n-1; i++){
            if(!visited[i]){
                visited[i] = true;
                select(i, count+1);
                visited[i] = false;
            }
        }
    }

    public static int team1Sum(){
        int sum =0;
        for(int i=0; i<n/2; i++){
            int p1 = team1[i];
            if(i==n/2){
                sum += ability[p1][0];
                sum += ability[0][p1];
                break;
            }
            for(int j=i+1; j<n/2; j++){
                int p2 = team1[j];
                sum += ability[p1][p2];
                sum += ability[p2][p1];
            }
        }
        return sum;
    }
    public static int team2Sum(){
        int[] team2 = checkTeam2();

        int sum =0;
        for(int i=0; i<n/2; i++){
            int p1 = team2[i];
            if(i==n/2){
                sum += ability[p1][0];
                sum += ability[0][p1];
                break;
            }
            for(int j=i+1; j<n/2; j++){
                int p2 = team2[j];
                sum += ability[p1][p2];
                sum += ability[p2][p1];
            }
        }
        return sum;
    }
    public static int[] checkTeam2(){
        int[] team2 = new int[n/2];

        int count =0;
        for(int i=0; i<n; i++){
            boolean isInclude = false;
            for(int j=0; j<n/2; j++){
                if(i == team1[j]){
                    isInclude = true;
                }
            }

            if(!isInclude){
                team2[count++] = i;
            }
        }
        return team2;
    }
}
