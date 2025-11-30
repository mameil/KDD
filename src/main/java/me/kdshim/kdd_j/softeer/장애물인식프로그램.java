//package me.kdshim.kdd_j.softeer;
//
//import java.util.*;
//import java.io.*;
//
//
//public class Main
//{
//    static int[][] arr;
//    static boolean[][] visited;
//    static int cnt = 0;
//    static ArrayList<Integer> deptCnt = new ArrayList<>();
//
//    public static void main(String args[]) throws Exception
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        arr = new int[n][n];
//        visited = new boolean[n][n];
//        visited[0][0] = true;
//        for(int i=0; i<n; i++){
//
//            String[] stringSplit = br.readLine().split("");
//            int[] split = new int[stringSplit.length]
//            for(int j=0; j<split.length; j++){
//                split[j] = Integer.parseInt(stringSplit[j]);
//            }
//
//            for(int j=0; j<n; j++){
//                arr[i][j] = split[j];
//            }
//        }
//
//        remark(0,0);
//
//    }
//
//    public static void remark(int x, int y){
//        Queue<int[]> q = new LinkedList<int[]>();
//
//        q.add(new int[] {x, y});
//
//        int[] dx = {1, 0, -1, 0};
//        int[] dy = {0, 1, 0, -1};
//
//        while(!q.isEmpty()){
//            int[] xy = q.poll();
//
//            for(int i=0; i<4; i++){
//                int nextX = xy[0] + dx[i];
//                int nextY = xy[1] + dy[i];
//
//                if(nextX<0 || nextX>=n || nextY<0 || nextY>=n || visited[nextX][nextY] || arr[nextX][nextY] == 0){
//                    continue;
//                }
//
//                q.add(new int[] {nextX, nextY});
//                visited[nextX][nextY] = true;
//                cnt++;
//
//            }
//        }
//    }
//}
