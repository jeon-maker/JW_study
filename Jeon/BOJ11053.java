package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ11053 {
    public void BOJ11053_start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        List<Integer> arr = new ArrayList<Integer>();
        String input = br.readLine();
        String[] inputs = input.split(" ");
        int max = 0;
        int cnt = 0;
        for(int i=0; i<n; i++){
            int val = Integer.parseInt(inputs[i]);
            if(max >= val) continue;
            else{
                max = val;
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
