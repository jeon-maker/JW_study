package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    static Integer[] dp;
    static int[] arr;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        dp = new Integer[n];
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);
        for(int i=3; i<n; i++){
            dp[i] = recursive(i);
        }
        System.out.println(dp[n-1]);
    }
    static int recursive(int k){
        if(dp[k] == null){
            dp[k] = Math.max(arr[k-1] + dp[k-3] + arr[k], dp[k-2] + arr[k]);
        }
        return dp[k];
    }
}
