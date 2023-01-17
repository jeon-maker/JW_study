package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11725 {

    public void boj11725_start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        int[][] arr = new int[n+1][2];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        for(int i=0; i<n; i++){
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int i1 = Integer.parseInt(inputs[0]);
            int i2 = Integer.parseInt(inputs[1]);
            boj11725_make_arr(arr,i1,i2);
        }
        boj11725_print(arr,n);
    }

    public void boj11725_make_arr(int[][] arr, int i1, int i2){
        if(arr[i1][0] == 0){
            arr[i1][0] = arr[i2][0] + 1;
            arr[i1][1] = i2;
        } else if (arr[i2][0] == 0) {
            arr[i2][0] = arr[i1][0] + 1;
            arr[i2][1] = i2;
        }
    }
    public void boj11725_print(int[][] arr,int n){
        for(int i=2; i<n; i++){
            System.out.println(arr[i][1]);
        }
    }
}
