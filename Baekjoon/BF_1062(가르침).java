import java.io.*;

class Main{
    static String[] words;
    static boolean[] alphabet = new boolean[26];
    static int max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        if(k<5){
            System.out.println("0");
            return;
        }

        words = new String[n];
        for(int i=0; i<n; i++){
            words[i] = br.readLine();
        }


        //a==0 c==2 n==13 t ==19 i==8 는 항상 필수
        alphabet[0] = true;
        alphabet[2] = true;
        alphabet[8] = true;
        alphabet[13] = true;
        alphabet[19] = true;
        k = k-5;
        combination(0, k);
        System.out.println(max);
    }
    static void combination(int start, int r){
        if(r==0){
            //해당 알파벳으로 얼만큼 읽을 수 있는지 체크
            int count = readWords();
            max = Math.max(max, count);
            return;
        }
        for(int i=start; i<26; i++){
            if(i==0 || i==2 || i==8 || i==13 || i ==19) continue;
            alphabet[i] = true;
            combination(i+1, r-1);
            alphabet[i] = false;
        }
    }
    static int readWords(){
        int result = 0;
        for(int i=0; i<words.length; i++){
            String word = words[i];
            boolean flag=true;
            for(int j=0; j<word.length(); j++){
                int index = word.charAt(j) - 'a';

                if(!alphabet[index]){
                    flag = false;
                    break;
                }
            }
            if(flag) result++;
        }
        return result;
    }
}
