package com.Beakjoon;
import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[] op;
    static int[] number;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        number = new int[n];
        for(int i=0; i<n; i++){
            number[i] = Integer.parseInt(str[i]);
        }
        op = new int[n-1]; //뎃셈0 뺄셈1 곱셈2 나눗셈3 으로 개수 만큼 입력
        visited = new boolean[n-1];
        str = br.readLine().split(" ");
        int index=0;
        for(int i=0; i<4; i++){
            int num = Integer.parseInt(str[i]);
            for(int j=0; j<num; j++){
                op[index] = i;
                index++;
            }
        }

        //dfs 모든 정점 탐색
        for(int i=0; i<n-1; i++){
            visited[i] = true;
            dfs(op[i], 1, number[0]);
            visited[i] = false;
        }

        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int opIndex, int count, int sum){
        //종료시점? 더이상 돌게 없을땐데
        if(count == n-1){
            //최대 최소 비교
            sum = update(sum, opIndex,count);
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        int newSum=0;
        newSum = update(sum, opIndex, count);
        for(int i=0; i<n-1; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(op[i], count+1, newSum);
                visited[i] = false;
            }
        }
    }
    public static int update(int sum, int op, int count){

        if(op == 0){ //+
            sum = sum + number[count];
        }
        else if(op == 1){ //-
            sum = sum - number[count];
        }
        else if(op == 2){ //*
            sum = sum * number[count];
        }else if(op == 3){ ///
            sum = sum / number[count];
        }

        return sum;
    }
}
