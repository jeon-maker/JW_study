package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15886 {
    static int[] step;
    static String[] map;

    static int ans_double = 0;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        map = new String[n];
        step = new int[n];
        String map_val = br.readLine();
        for(int i=0; i<n; i++){
            map[i]= map_val.substring(i,i+1);
        }
        for(int i=0; i<n; i++){
            detection(i,map[i],n);
        }
        for(int i=0; i<n; i++){
            System.out.println("step[i] = " + step[i]);
            if(step[i]>=n){
                ans_double+=1;
            }
        }
        
        System.out.println(ans_double/2);
    }
    public void detection(int idx,String s,int n){
        if(step[idx] >= n ){
            return;
        }
        step[idx] += 1;
        if(s.equals("E")){
            String l = map[idx+1];
            detection(idx+1,l,n);
        }else{
            String l = map[idx-1];
            detection(idx-1,l,n);
        }
    }

}
