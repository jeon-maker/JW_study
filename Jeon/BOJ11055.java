package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11055 {
    static int[] arr;
    static Integer[] dp;
    static int max ;

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        String input = br.readLine();
        arr = new int[n];
        dp = new Integer[n];
        String[] inputs = input.split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        dp[0] = arr[0];
        max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max,recursive(i));
        }
        System.out.println(max);
    }
    static int recursive(int k){
        if(dp[k] == null){
            dp[k] = arr[k];
            for(int i=k-1; i>=0; i--){
                if(arr[i] < arr[k]){
                    dp[k] = Math.max(dp[k],recursive(i) + arr[k]);
                }
            }
            }
        return dp[k];
    }
}
