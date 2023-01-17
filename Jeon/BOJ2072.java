package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2072 {
    static int[][] black = new int[20][20];
    static int[][] white = new int [20][20];

    //방문시 1
    static int[][] up_down_visited = new int[19][19];
    static int[][] left_right_visited = new int[19][19];
    static int[][] right_cross_visited = new int[19][19];
    static int[][] left_cross_visited = new int[19][19];

    ArrayList<Integer> up_down_list = new ArrayList<Integer>();
    ArrayList<Integer> left_right_list = new ArrayList<Integer>();
    ArrayList<Integer> right_cross_list = new ArrayList<Integer>();
    ArrayList<Integer> left_cross_list = new ArrayList<Integer>();

    ArrayList<Integer> ans_list = new ArrayList<Integer>();

    ArrayList<Integer> up_down_list_black = new ArrayList<Integer>();
    ArrayList<Integer> left_right_list_black = new ArrayList<Integer>();
    ArrayList<Integer> right_cross_list_black = new ArrayList<Integer>();
    ArrayList<Integer> left_cross_list_black = new ArrayList<Integer>();


    public void boj2072_start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);

        for(int i=1; i < n+1; i++){
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            //홀수 -> 흑
            if(i % 2 != 0){
                black[x][y] = i;
            }else{
                white[x][y] = i;
            }
        }
        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                up_down(i,j,0);
                up_down_black(i,j,0);
                left_right(i,j,0);
                left_right_black(i,j,0);
                right_cross(i,j,0);
                right_cross_black(i,j,0);
                left_cross(i,j,0);
                left_cross_black(i,j,0);

            }
        }
        if(ans_list.isEmpty()){
            System.out.println("-1");
        }else{
            System.out.println(  Collections.max(ans_list));
        }

    }
    public void up_down(int x, int y, int cnt){
        if(x> 18 || y> 18 || x<0 || y<0){
            return;
        }
        if(cnt != 5 && white[x][y] ==0){
            up_down_list = new ArrayList<Integer>();
            return;
        }
        if(cnt == 5 && white[x][y] == 0 ){
            ans_list.add(Collections.max(up_down_list));
        }
        if(cnt == 5 && white[x][y] != 0 ){
            return;
        }
        if( white[x][y] != 0 && up_down_visited[x][y] == 0 ){
            up_down_visited[x][y] = 1;
            up_down_list.add(white[x][y]);
            up_down(x,y+1,cnt+1);
        }

    }
    public void left_right(int x, int y, int cnt){
        if(x> 18 || y> 18 || x<0 || y<0){
            return;
        }
        if(cnt != 5 && white[x][y] ==0){
            left_right_list = new ArrayList<Integer>();
            return;
        }
        if(cnt == 5 && white[x][y]!=0 && white[x+1][y] == 0){
            ans_list.add(Collections.max(left_right_list));
        }
        if( white[x][y] != 0 && left_right_visited[x][y] == 0 ){
            left_right_visited[x][y] = 1;
            left_right_list.add(white[x][y]);
            left_right(x+1,y,cnt+1);
        }

    }
    public void right_cross(int x, int y, int cnt){
        if(x> 18 || y> 18 || x<0 || y<0){
            return;
        }
        if(cnt != 5 && white[x][y] ==0){
            right_cross_list = new ArrayList<Integer>();
            return;
        }
        if(cnt == 5 && white[x][y]!=0 && white[x+1][y+1] == 0){
            ans_list.add(Collections.max(right_cross_list));
        }
        if( white[x][y] != 0 && right_cross_visited[x][y] == 0 ){
            right_cross_visited[x][y] = 1;
            right_cross_list.add(white[x][y]);
            right_cross(x+1,y+1,cnt+1);
        }

    }
    public void left_cross(int x, int y, int cnt){
        if(x> 18 || y> 18 || x<0 || y<0 ){
            return;
        }
        if(cnt != 5 && white[x][y] ==0){
            left_cross_list = new ArrayList<Integer>();
            return;
        }
        if(cnt == 5 && white[x][y]!=0 && white[x-1][y+1] == 0){
            ans_list.add(Collections.max(left_cross_list));
        }
        if( white[x][y] != 0 && left_cross_visited[x][y] == 0 ){
            left_cross_visited[x][y] = 1;
            left_cross_list.add(white[x][y]);
            left_cross(x-1,y+1,cnt+1);
        }

    }

    public void up_down_black(int x, int y, int cnt){
        if(x> 18 || y> 18 || x<0 || y<0){
            return;
        }
        if(cnt != 5 && black[x][y] ==0){
            up_down_list_black = new ArrayList<Integer>();
            return;
        }
        if(cnt == 5 && black[x][y]!=0 && black[x][y+1] == 0){
            ans_list.add(Collections.max(up_down_list_black));
        }
        if( black[x][y] != 0 && up_down_visited[x][y] == 0 ){
            up_down_visited[x][y] = 1;
            up_down_list_black.add(black[x][y]);
            up_down_black(x,y+1,cnt+1);
        }
    }
    public void left_right_black(int x, int y, int cnt){
        if(x> 18 || y> 18 || x<0 || y<0 ){
            return;
        }
        if(cnt != 5 && black[x][y] ==0){
            left_right_list_black = new ArrayList<Integer>();
            return;
        }
        if(cnt == 5 && black[x][y] != 0 && black[x+1][y] == 0){
            ans_list.add(Collections.max(left_right_list_black));
        }
        if( black[x][y] != 0 && left_right_visited[x][y] == 0 ){
            left_right_visited[x][y] = 1;
            left_right_list_black.add(black[x][y]);
            left_right_black(x+1,y,cnt+1);
        }
    }
    public void right_cross_black(int x, int y, int cnt){
        if(x> 18 || y> 18 || x<0 || y<0){
            return;
        }
        if(cnt != 5 && black[x][y] ==0){
            right_cross_list_black = new ArrayList<Integer>();
            return;
        }
        if(cnt == 5 && black[x][y]!= 0 && black[x+1][y+1] == 0){
            ans_list.add(Collections.max(right_cross_list_black));
        }
        if( black[x][y] != 0 && right_cross_visited[x][y] == 0 ){
            right_cross_visited[x][y] = 1;
            right_cross_list_black.add(black[x][y]);
            right_cross_black(x+1,y+1,cnt+1);
        }

    }
    public void left_cross_black(int x, int y, int cnt){
        if(x> 18 || y> 18 || x<0 || y<0){
            return;
        }
        if(cnt != 5 && black[x][y] ==0){
            left_cross_list_black = new ArrayList<Integer>();
            return;
        }
        if(cnt == 5 && black[x][y]!=0 && black[x-1][y+1] == 0){
            ans_list.add(Collections.max(left_cross_list_black));
        }
        if( black[x][y] != 0 && left_cross_visited[x][y] == 0 ){
            left_cross_visited[x][y] = 1;
            left_cross_list_black.add(black[x][y]);
            left_cross_black(x-1,y+1,cnt+1);
        }

    }
}
