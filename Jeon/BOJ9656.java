package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9656 {
    // 1개 또는 3개
    // n개 남았을 때 ->
    // 내가 지는지 아닌지를 판단 해야함
    // 시작때 승부가 갈릴듯
    // 이기는 방법 -> 마지막 숫자 전 숫자를 가져가기
    // 4면 1 2 3 4 에서 3을 가져가면 됨
    // 3을 외치거나 1을 외치면 됨
    // 5면 1 2 3 4 5 에서 4를 가져가면 됨
    // 1을 내도 지고 3을 내도 짐
    // 10 이면 1 2 3 4 6 5  7 8 9 10 에서 9를 가져가야함
    // 9를 가져가거나 5를 가져가면 이김
    // 5를 가져갈때 ->
    static String[] dp;
    public void BOJ9656_start() throws IOException {

        // 3이거나 1이거나 둘중 하나를 고르는데
        // 1을 넣거나 3을 넣는다 -> 1을 넣거나 3을 넣는다
        // 넣어준거에 +1이 되거나 +3이 된다
        // 먼저인 턴에서 전 숫자를 가져가면 끝난다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        dp = new String[n+4];
        dp[1] = "SK";
        dp[3] = "SK";
        for(int i=1; i<n; i++){
            String val = dp[i];
            dp(i,val);
            if(dp[n] != null){
                String loser = dp[n];
                if(loser.equals("SK")){
                    System.out.println("CY");
                }else{
                    System.out.println("SK");
                }
                break;
            }
        }
    }

    public void dp(int k,String val){
        int a = k+1;
        int b = k+3;
        String val_;
        if(val.equals("SK")){
             val_ = "CY";
        }else{
            val_="SK";
        }
        if(dp[a]==null){
            dp[a] = val_;
        }
        if(dp[b]==null){
            dp[b] = val_;
        }
    }
}
