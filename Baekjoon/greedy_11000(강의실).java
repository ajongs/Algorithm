import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>();
        Subject[] subjects = new Subject[n];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            subjects[i] = new Subject(start, end);
        }
        Arrays.sort(subjects);
        //먼저 첫번째 친구 강의실 배정해주자
        q.offer(subjects[0].end);
        for(int i=1; i<n; i++){
            //시작 시간이 가장 작은 친구들 부터 시작한다.
            if(q.peek() <= subjects[i].start){
                q.poll();
            }
            q.offer(subjects[i].end); //알아서 end 가 작은것이 큐의 앞으로 정렬
        }
        System.out.println(q.size());
    }
}
class Subject implements Comparable<Subject>{
    int start;
    int end;
    public Subject(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Subject o) {
        if(this.start == o.start){
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}
