package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11722 {
    static int[] arr;
    static Integer[] dp;
    static int max;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        arr = new int[n];
        String nums = br.readLine();
        String[] num = nums.split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(num[i]);
        }
        max = 0;
        dp = new Integer[n];
        dp[0] = 1;
        recursive(n-1);
//        System.out.println(dp[n-1]);
//        for(int i=0; i<n; i++){
//            System.out.println( "i = " + i + " dp[i] = " + dp[i]);
//        }
        for(int i= 0; i<n; i++){
            max = Math.max(max,recursive(i));
        }
        System.out.println(max);

    }
    static int recursive(int k){
        //System.out.println("k = " + k);
        if(dp[k]==null){
            dp[k] = 1;
            for(int i= k-1 ; i>=0 ; i--){
                if(arr[i] > arr[k]){
                    dp[k] = Math.max(dp[k],recursive(i)+1);
                }
            }

        }
        return dp[k];
    }
}
