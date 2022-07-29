import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        //sequence 배열의 인덱스 번호를 저장하는 스택
        Stack<Integer> stack = new Stack<>();

        String[] str = br.readLine().split(" ");

        //sequence 배열 초기화
        for(int i=0; i<n; i++){
            sequence[i] = Integer.parseInt(str[i]);
        }

        //sequence의 첫번째 인덱스 먼저 저장(비교할 앞 인덱스가 없으므로)
        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && sequence[stack.peek()] < sequence[i]){
                sequence[stack.pop()] = sequence[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            sequence[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(sequence[i]+" ");
        }

        System.out.println(sb);
    }
}
