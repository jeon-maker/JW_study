package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1912 {
    static int[] arr;
    static Integer[] dp;
    static int max;
    public void wrong_solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        String input = br.readLine();
        String[] inputs = input.split(" ");
        Long[] num = new Long[n];
        Long[] dp = new Long[n];
        for(int i=0; i<n; i++){
            num[i] = Long.parseLong(inputs[i]);
        }
        Long ans = 0L;
        Long max = 0L;
        for(int i=0; i<n; i++){
            Long start = num[i];
            for(int j=i+1; j<n; j++){
                start += num[j];
                dp[j] = start;
                if(max < dp[j]){
                    max = dp[j];
                }
            }
            dp = new Long[n];
        }
        System.out.println(max);

    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        String input = br.readLine();
        String[] inputs = input.split(" ");
        Long[] num = new Long[n];
        arr = new int[n];
        dp = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        dp[0] = arr[0];
        max = arr[0];
        dp_(n-1);
        System.out.println(max);
    }
    static int dp_(int k) {

        if(dp[k] == null){
            dp[k] = Math.max(dp_(k-1) + arr[k] , arr[k]);

            max = Math.max(dp[k],max);
        }
        return dp[k];
    }
}
