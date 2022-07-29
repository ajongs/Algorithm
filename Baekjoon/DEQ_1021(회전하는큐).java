import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++){
            deque.addLast(i);
        }

        int answer=0;
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(str[i]);
            int targetIdx = deque.indexOf(num);


            int front = deque.getFirst();
            int rear = deque.getLast();
            int rightCase = Math.abs(deque.indexOf(front) - targetIdx);
            int leftCase = Math.abs(deque.indexOf(rear) - targetIdx + 1);


            if(num == front){
                deque.removeFirst();
            }
            else{
                if(rightCase <= leftCase){
                    answer += rightCase;
                    right(num, deque);
                }
                else if(rightCase > leftCase){
                    answer += leftCase;
                    left(num, deque);
                }
            }
        }

        System.out.println(answer);
    }
    static void right(int num, LinkedList<Integer> deque){
        while(deque.getFirst()!=num){
            //오른쪽으로 돌리기
            deque.addLast(deque.getFirst());
            deque.removeFirst();
        }
        deque.removeFirst();
    }
    static void left(int num, LinkedList<Integer> deque){
        while(deque.getFirst()!=num){
            //왼쪽으로 돌리기
            deque.addFirst(deque.getLast());
            deque.removeLast();
        }
        deque.removeFirst();
    }
}
