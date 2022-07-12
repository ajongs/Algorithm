import java.io.*;
import java.util.*;
//HashSet은 정렬x , TreeSet은 오름차순 정렬
//Set은 인덱스가 없으므로 iterator나 for-each문 사용해야함
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Set<String> set = new HashSet<>();
        Set<String> answer = new TreeSet<>();
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }
        for(int i=0; i<m; i++){
            String s = br.readLine();
            if(set.contains(s)){
                answer.add(s);
            }
        }
        System.out.println(answer.size());
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
