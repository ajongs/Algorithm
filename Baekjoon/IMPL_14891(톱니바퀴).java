
import java.io.*;
import java.util.*;

class Main{
    static LinkedList<Integer>[] list;
    static LinkedList<Integer>[] copyList;
    static int[] dx = {-1, 1};
    static int[] visited = new int[5];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new LinkedList[5];
        for(int i=0; i<5; i++){
            list[i] = new LinkedList<>();
            visited[i] = 0;
        }
        for(int i=1; i<5; i++){
            String[] str = br.readLine().split("");

            for(int j=0; j<8; j++) {
                list[i].add(Integer.parseInt(str[j]));
            }
        }
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            String[] str = br.readLine().split(" ");

            int arrNum = Integer.parseInt(str[0]); //톱니 인덱스 1부터 4까지
            int dir = Integer.parseInt(str[1]); // 1 시계, -1 반시계
            Arrays.fill(visited, 0);
            visited[arrNum]= dir;
            dfs(arrNum, dir);
            rotation(); //톱니바퀴가 한번에 바뀌어야함
        }
        int result=0;
        for(int i=0; i<4; i++){
            if(list[i+1].get(0)==1){
                result += Math.pow(2,i);
            }
        }
        System.out.println(result);
    }
    static void dfs(int start, int dir){
        //앞이나 뒤로 이동하며 (왼 / 오)
        for(int i=0; i<dx.length; i++){
            int nextNum = start+dx[i];

            int myIndex; //양쪽의 톱니바퀴에 맞닿는 부분
            int nextIndex; //양쪽 톱니바퀴가 자신 톱니바퀴와 맞닿는 부분
            if(dx[i]==-1){ //왼쪽 검사할때
                myIndex = 6;
                nextIndex =2;
            }
            else{ //오른쪽 검사할때
                myIndex = 2;
                nextIndex = 6;
            }

            if(nextNum >0 && nextNum <=4){
                //다음 톱니바퀴가 아직 방문하지 않았고 서로의 극이 다르경우만
                if(visited[nextNum]==0 && list[start].get(myIndex) != list[nextNum].get(nextIndex)) {
                    visited[nextNum] = -dir;
                    dfs(nextNum, -dir);
                }
            }
        }
        return;
    }
    static void rotation(){
        for(int i=1; i<5; i++){
            if(visited[i]==-1){
                list[i].addLast(list[i].removeFirst());
            }
            else if(visited[i]==1){
                list[i].addFirst(list[i].removeLast());
            }
        }
    }
}
