package com.Beakjoon;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int length = 'z'-'a'+1;
        int[] arr = new int[length];

        int count=0;

        for(int i=0; i<n; i++){
            String str = br.readLine();
            boolean isGroup = true;
            for(int j=0; j<str.length(); j++){
                int index = str.charAt(j)-'a';
                if(j>0){
                    if(arr[index] >0 && str.charAt(j)==str.charAt(j-1)){
                        continue;
                    }
                    else if(arr[index] >0 && str.charAt(j)!=str.charAt(j-1)){
                        isGroup = false;
                        break;
                    }
                }
                arr[index]++;
            }
            if(isGroup){
                count++;
            }
            arr = new int[length];
        }
        System.out.println(count);
    }
}
