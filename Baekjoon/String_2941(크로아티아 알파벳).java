package com.Beakjoon;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        int answer=0;

        for(int i=0; i<croatia.length; i++){
            int isExist = sb.indexOf(croatia[i]);
            if(isExist == -1 ){
                continue;
            }
            else{
                while(isExist!=-1){
                    sb.replace(isExist, isExist+croatia[i].length(), " ");
                    answer++;
                    isExist = sb.indexOf(croatia[i]);
                }
            }
        }
        String s = sb.toString().replaceAll(" ","");

        if(s.equals("")){
            System.out.println(answer);
            return;
        }
        answer += s.length();


        System.out.println(answer);
    }
}
