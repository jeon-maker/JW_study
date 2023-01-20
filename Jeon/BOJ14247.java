package Solution;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class BOJ14247 {

    public static void solution(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        String start = br.readLine();
        String[] starts = start.split(" ");

        String grow = br.readLine();
        String[] grows = grow.split(" ");
        int[] grow_speed = new int[n];
        Long hap = 0L;
        for(int i=0; i<n; i++) {
            hap+= Long.parseLong(starts[i]);
            grow_speed[i] = Integer.parseInt(grows[i]);
        }
        Arrays.sort(grow_speed);
        for(int i=0; i<n; i++){
            hap += grow_speed[i] * i;
        }

        System.out.println(hap);
    }
}


