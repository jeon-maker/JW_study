package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ10773 {
    public void BOJ10773_start() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = Integer.parseInt(str);
        List<Integer> nums = new ArrayList<Integer>();
        for(int i=0; i<size; i++){
            String say = br.readLine();
            int num = Integer.parseInt(say);
            if(num == 0){
                int trash = nums.get(nums.size()-1);
            }else{
                nums.add(num);
            }
        }
        int hap = 0;
        for (int i=0; i< nums.size(); i++){
            hap += nums.get(i);
        }
        System.out.println(hap);

    }
}
