import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //알파벳 배열 만들고
        int[] alpha = new int[26];
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i=0; i<n; i++){
            words[i] = br.readLine();
        }
        //각 자리수를 곱하는 로직 시작
        for(int i=0; i<n; i++){
            int location=1;
            for(int j=words[i].length()-1; j>=0; j--){
                alpha[words[i].charAt(j)-'A'] += location;
                location*=10;
            }
        }

        //큐 만들기
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return alpha[o2] - alpha[o1];
            }
        });
        for(int i=0; i<26; i++){
            if(alpha[i] >0){
                q.offer(i);
            }
        }
        int num=9;
        int result=0;
        while(!q.isEmpty()){
            int idx = q.poll();

            result += alpha[idx]*num--;
        }
        System.out.println(result);
    }
}
