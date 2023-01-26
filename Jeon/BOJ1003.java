package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {

    static Integer[] zero_dp;
    static Integer[] one_dp;
    static int zero;
    static int one;
    static int[][] ans ;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        zero = 0;
        one = 0;
        int t = Integer.parseInt(str);
        ans = new int[t][2];
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            zero_dp = new Integer[n + 2];
            one_dp = new Integer[n + 2];
            zero_dp[0] = 1;
            zero_dp[1] = 0;
            one_dp[0] = 0;
            one_dp[1] = 1;
            zero_recursive(n);
            one_recursive(n);
            ans[i][0] = zero_dp[n];
            ans[i][1] = one_dp[n];
        }
        for(int i=0; i<t; i++){
            System.out.println(ans[i][0] +" "+ans[i][1]);
        }
    }
    static int zero_recursive(int n){
        if(zero_dp[n] == null){
            zero_dp[n] = zero_recursive(n-1) + zero_recursive(n-2);
        }
        return zero_dp[n];
    }

    static int one_recursive(int n){
        if(one_dp[n] == null){
            one_dp[n] = one_recursive(n-1) + one_recursive(n-2);
        }
        return one_dp[n];
    }
}
