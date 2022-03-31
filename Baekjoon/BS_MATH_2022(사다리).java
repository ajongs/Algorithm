package com.Beakjoon;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        double x = Double.parseDouble(str[0]);
        double y = Double.parseDouble(str[1]);
        double c = Double.parseDouble(str[2]);

        double left=0;
        double right = Math.min(x,y);

        for(int i=0; i<10000; i++){
            double dis = (left+right)/2; //여기서는 dis가 mid 역할

            double h1 = Math.sqrt(x*x - dis*dis);
            double h2 = Math.sqrt(y*y - dis*dis);

            double ec = h1*h2 / (h1+h2);

            if(ec <= c){
                right = dis;
            }
            else
                left = dis;

        }

        System.out.printf("%.3f", left);

        br.close();
    }
}
