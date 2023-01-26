package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ9095 {
    static int[] dp;
    static int[] ans;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int t = Integer.parseInt(str);
        dp = new int[11];
        ans = new int[t];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=10; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int i=0; i<t; i++){
            int k = Integer.parseInt(br.readLine());
            ans[i] = dp[k];
        }
        for(int i=0; i<t; i++){
            System.out.println(ans[i]);
        }
    }
}
