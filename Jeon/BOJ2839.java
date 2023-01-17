package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
    static int three_cnt = 0;
    static int five_cnt = 0;
    static int possible = 0;
    public void BOJ2839_start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        solution(n);
        if(possible == 0) {
            System.out.println(three_cnt + five_cnt);
        }
    }
    public void solution(int n){
        if(n<3){
            System.out.println(-1);
            possible = 1;
            return;
        }
        if(n%5 != 3){
            three_cnt += 1;
            solution(n-3);
        }else{
            five_cnt += n/5;
            three_cnt += 1;
        }
    }
}
