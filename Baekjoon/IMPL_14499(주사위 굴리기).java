import java.io.*;
import java.util.*;

class Main{
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] map;
    static LinkedList<Integer> rDec = new LinkedList<>();
    static LinkedList<Integer> cDec = new LinkedList<>();
    static int[] order;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]); //세로
        m = Integer.parseInt(str[1]); //가로
        int x = Integer.parseInt(str[2]); //x == r
        int y = Integer.parseInt(str[3]);
        int k = Integer.parseInt(str[4]); //명령의 갯수
        order = new int[k];
        map = new int[n][m];
        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");

            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<4; i++){
            cDec.addLast(0);
        }
        for(int i=0; i<3; i++){
            rDec.addLast(0);
        }

        str = br.readLine().split(" ");
        for(int i=0; i<k; i++){
            order[i] = Integer.parseInt(str[i]);
        }
        play(x,y,0);

    }
    static void play(int r, int c, int oIndex){
        //명령 다 수행하면 끝
        if(oIndex == order.length){
            return;
        }
        for(int i=oIndex; i<order.length; i++){
            int nextDir = order[i]-1;

            int nextR = r+dr[nextDir];
            int nextC = c+dc[nextDir];

            if(nextR >=0 && nextR<n && nextC >=0 && nextC <m){
                if(map[nextR][nextC]==0){
                    //현재 주사위 바닥 복사에서 넣기
                    throwDice(nextDir);
                    map[nextR][nextC] = checkDiceFloor();
                }
                else{
                    //현재 칸 주사위 바닥에 복사 후
                    throwDice(nextDir);
                    cDec.removeLast();
                    cDec.addLast(map[nextR][nextC]);
                    //칸 0 으로 바꿈
                    map[nextR][nextC] = 0;
                }
                System.out.println(rDec.get(1));
                play(nextR, nextC, ++i);  //여기서 막혔음 i를 주면안됨 i는 아직 변하기 전 상태이므로 i+1이나 ++i를 주는 것이 맞음 
                break;
            }
        }
    }
    static int checkDiceFloor(){
        return cDec.getLast();
    }
    static void throwDice(int dir){
        if(dir == 0){ //동 (오른쪽으로 굴림             //일단 rDec을 오른쪽으로 이동
            rDec.addFirst(cDec.removeLast());
            cDec.addLast(rDec.removeLast());
            cDec.remove(1);
            cDec.add(1, rDec.get(1));

        }else if(dir == 1){ //서
            int floor = rDec.removeFirst();
            rDec.addLast(cDec.removeLast());
            cDec.addLast(floor);
            cDec.remove(1);
            cDec.add(1, rDec.get(1));
        }else if(dir == 2){ //북
            //cDec부터 이동
            int floor = cDec.removeFirst();
            cDec.addLast(floor);
            rDec.remove(1);
            rDec.add(1, cDec.get(1));
        }else {
            cDec.addFirst(cDec.removeLast());
            rDec.remove(1);
            rDec.add(1, cDec.get(1));
        }
    }

}
