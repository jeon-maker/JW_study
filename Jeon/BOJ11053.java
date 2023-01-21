package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ11053 {
    static int arr[];
    static Integer dp[];
    static int max;

    static int cnt;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        arr = new int[n];
        dp = new Integer[n];
        String input = br.readLine();
        String[] inputs = input.split(" ");
        cnt = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        dp[0] = 1;
        max = 1;
        cnt = 1;
        for(int i=0; i<n; i++){
            max = Math.max(recursive(i),max);
        }
        System.out.println(max);
    }
    static int recursive(int k){
        if(dp[k] == null){
            dp[k] = 1;
            for(int i=k-1; i>=0; i--){
                if(arr[i] < arr[k]){
                    dp[k] = Math.max(dp[k],recursive(i)+1);
                }
            }
        }
        return dp[k];
    }
}
