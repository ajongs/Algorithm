import java.util.*;
import java.io.*;

class Main{
    static int L, C;
    static String[] data;
    static int vowels=0; //모음
    static int consonants=0; //자음
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // 1. 최소 한개모음, 최소 두개자음
        // 2. L(실제 암호 개수), C(경우의 수)
        // 3. 오름차순 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        L = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        data = br.readLine().split(" ");
        Arrays.sort(data);
        List<String> str = new ArrayList<>();
        search(0,0, str);
        
        for(String s : result){
            System.out.println(s);
        }
    }
    static void search(int start, int num, List<String> str){
      if(num==L){
        String temp = new String();
        for(String s : str){
          temp += s;
          if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")){
            vowels++;
          }
          else
            consonants++; 
        }
        if(vowels >=1 && consonants >=2){
            result.add(temp);
        }
        vowels=0;
        consonants=0;
        return;
      }
      for(int i=start; i<C; i++){
          str.add(data[i]);
          search(i+1, num+1, str);
          str.remove(data[i]);
      }
    }
}
