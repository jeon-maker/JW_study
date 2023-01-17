package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10971 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            String input = br.readLine();
            String[] inputs = input.split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        bfs(map,n);
        // 시작점을 바꿔가며 bfs 실행하기
    }
    public void bfs(int[][] map,int n){
        Queue<Integer> que = new LinkedList<>();
        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int val = map[i][j];
                if(val != 0 && visited[i][j] == 0){
                    que.add(j);
                    visited[i][j] = 1;
                    visited[j][i] = 1;
                }
                while(que.size() != 0){
                    Integer pop = que.remove();
                    // 큐에는 정점과 연결된 인덱스가 들어가 있음
                    // pop은 정점과 연결된 인덱스들
                    // 경로 값을 저장할 곳이 필요함.
                }
            }
        }
    }
}
