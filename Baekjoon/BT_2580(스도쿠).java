package com.Beakjoon;
import java.util.*;
import java.io.*;

class Main{
    static int n=9;
    static int[][] map;
    static ArrayList<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[n][n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                int item = Integer.parseInt(str[j]);
                if(item == 0) list.add(new Point(i, j));
                map[i][j] = item;
            }
        }
        inputNum(0);
    }

    
    public static void inputNum(int count){
        if(count==list.size()){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        Point point = list.get(count);
        for(int i=1; i<n+1; i++){
            if(isNotContain(i, point)){
                map[point.i][point.j] = i;
                inputNum(count+1);
            }
        }
    }
    public static boolean isNotContain(int num, Point point){
        //가로 검사
        for(int j=0; j<n; j++){
            if(j== point.j) continue;
            if(map[point.i][j] == num) return false;
        }
        //세로 검사
        for(int i=0; i<n; i++){
            if(i == point.i) continue;
            if(map[i][point.j] == num) return false;
        }
        // 3x3 범위 검사
        int r_block = (point.i/3)*3;
        int c_block = (point.j/3)*3;

        for(int i=r_block; i<r_block+3; i++){
            for(int j=c_block; j<c_block+3; j++){
                if(map[i][j] == num) return false;
            }
        }
        // 세 검사에 안걸리면 true
        return true;
    }
    static class Point{
        int i;
        int j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
