package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1699 {
    static int[] dp;
    static int[] arr;
    static int num;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        num = n;
        dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = i;
            for(int k=1; k * k <= i; k++){
                if(dp[i] > dp[i-(k*k)] +1){
                    dp[i] = dp[i-(k*k)] + 1;
                }
            };
        }
        System.out.println(dp[n]);
        }

    }
