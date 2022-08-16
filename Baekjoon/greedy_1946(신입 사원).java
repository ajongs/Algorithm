import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> q = new PriorityQueue<>();
            Score[] scores = new Score[n];

            for(int j=0; j<n; j++){
                String[] str = br.readLine().split(" ");
                int doc = Integer.parseInt(str[0]);
                int itv = Integer.parseInt(str[1]);
                scores[j] = new Score(doc, itv);
            }
            //앞에꺼 오름 차순 정렬
            Arrays.sort(scores, new Comparator<Score>() {
                @Override
                public int compare(Score o1, Score o2) {
                    return o1.document - o2.document;
                }
            });
            q.offer(scores[0].interview);
            for(int k=1; k<n; k++){
                if(q.peek() < scores[k].interview) continue;
                q.offer(scores[k].interview);
            }
            System.out.println(q.size());
        }
    }
}
class Score {
    int document;
    int interview;
    public Score(int document, int interview){
        this.document = document;
        this.interview = interview;
    }
}
