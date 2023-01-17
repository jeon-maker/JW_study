package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ16112 {
    public void boj16112_start() throws IOException {
        Scanner scan = new Scanner(System.in);
        int quest = scan.nextInt();
        int activeS = scan.nextInt();
        int [] arr = new int [quest];
        for(int i = 0; i < quest; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        int exp = 0;
        for(int i=0; i<quest; i++){
            if(count<activeS){
                count += 1;
                exp -= arr[i];
            }
            exp += arr[i];
        }
        System.out.println(exp);}
}
