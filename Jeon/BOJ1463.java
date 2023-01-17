package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1463  {
    static List<Integer> present = new ArrayList<Integer>();
    static List<Integer> next = new ArrayList<Integer>();
    static int cnt = 0;
    static int find = 0;
    public void BOJ1463_start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 1 까지 가봐야 알 수 있음
        // 1까지 어떤 알고리즘으로 갈 것인가?
        // 1에서 숫자까지 갈까?
        // 모든 케이스를 다 탐색 하는 방법이 필요함
        // 트리 구조 -> 3으로 나누기 , 2로 나누기 , 1 빼기                               3개
        // -> 3으로 나눈것에서 또 3으로 나누기, 2로 나누기 1 빼기 즉, 동적 할당이 필요함.     9개
        //1개 -> 3개 -> 9개 -> 27개 ->  2,3,4번일때 cnt +1
        // cnt 변수를 따로 만들어서 +1을 하는 방식을 택하고, 배열을 매번 새로 만든다?
        // -> 배열 두개를 통해서 현재 단계 -> 다음 단계를 만들고, 다음 단계가 현재 단계 배열로 오고 현재 단계가 다음 단계 배열로 옴
        int num = Integer.parseInt(str);
        solutions(num);
        cnt += 1;
        while(true){
            if(next.contains(1)){
                break;
            }
            else{
                present = next;
                next = new ArrayList<Integer>();
            }
            int size = present.size();
            for (Integer integer : present) {
                solutions(integer);
            }
            cnt += 1;
        }
        System.out.println(cnt);

    }
    public void solutions(int num){
        if(num%3 == 0){
            next.add(num/3);
        }
        if(num%2 == 0){
            next.add(num/2);
        }
        next.add(num-1);
    }
}
