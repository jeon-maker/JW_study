package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2491 {

    static int[] dp;
    static int[] reverse_dp;
    public void boj2491_start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = Integer.parseInt(str);
        int[] arr = new int[size+1];
        String nums = br.readLine();
        String[] num = nums.split(" ");
        for(int i=0; i<size; i++){
            arr[i+1] = Integer.parseInt(num[i]);
        }
        dp = new int[size+1];
        reverse_dp = new int[size+1];
        int cnt = 1;

        for(int i=1;i<size+1;i++){
            if(arr[i]>=arr[i-1]){
                cnt += 1;
                dp[i] = cnt;
            }
            else{
                cnt = 1;
                dp[i] = cnt;
            }
        }
        int r_cnt = 1;
        for(int i=0; i<size ; i++){
            if(arr[size-i]<=arr[size-(i+1)]){
               r_cnt +=1;
               reverse_dp[i+1] = r_cnt;
            }
            else{
                r_cnt = 1;
                reverse_dp[i+1] = r_cnt;
            }
        }
        int max = 0;
        int r_max = 0;
        for(int i=1;i<size+1;i++){
            if(dp[i]>max){
                max = dp[i];
            }
            if(reverse_dp[i] > r_max){
                r_max = reverse_dp[i];
            }
        }
        if(r_max>max){
            System.out.println(r_max);
        }else{
            System.out.println(max-1);
        }
    }
}
