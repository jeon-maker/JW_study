package Solution;


import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] arg) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                int n = Integer.parseInt(str);
                int[] arr = new int[12]; // 방향 기록
                int gaRo = 0;
                int seRo = 0;
                StringBuffer nums = new StringBuffer("");
                for(int i=0; i<6; i++){
                    String input = br.readLine();
                    String[] inputs = input.split(" ");
                    nums.append(inputs[0]);
                    int v = Integer.parseInt(inputs[0]);
                    int s = Integer.parseInt(inputs[1]);
                    arr[i] = s;
                    arr[i+6] = s;
                    if(v == 4 || v== 3){
                        if(s>=seRo){
                            seRo = s;
                        }
                    }
                    if(v == 1 || v == 2 ){
                        if(s>=gaRo){
                            gaRo = s;
                        }
                    }
                }
                int a=0;
                int b=0;
                nums.append(nums);
//        System.out.println("nums = " + nums);
                List<String> objects = Arrays.asList("1313","2323","1414","2424","3131","4141","3232","4242");
                for(int i=0; i<8; i++){
                    String s = objects.get(i);
                    int idx = nums.indexOf(s);
//            System.out.println("s = " + s);
                    if(idx!=-1){
//            System.out.println(idx);
                        a = idx+1;
                        b=  idx+2;
                        if(a>=6){
                            a = a-6;
                            b = b-6;
                        }
                        break;
                    }
                }
                int square = gaRo * seRo;
                int total = square - (arr[a]*arr[b]);
//                System.out.println(a);
//                System.out.println(b);
                System.out.println(total * n);
            }
        }


