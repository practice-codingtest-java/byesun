// https://www.acmicpc.net/problem/2667

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 인접 행렬을 입력을 받는다.알고리즘은 DFS 선택
 * 상, 하, 좌, 우로 이동할 수 있게 한다.
 * dfs로 집의 개수를 List에 반환한다.
 * 내부에서 집의 개수는 오름차순으로 출력하기 위해서 정렬을 해주고
 * 출력!
 */
public class 단지번호붙이기2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        List<Integer> answer = new ArrayList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j]==1 && !visited[i][j]) {
                    int count = dfs(i,j,graph,visited,dx,dy,n);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer i : answer) {
            System.out.println(i);
        }
    }

    private static int dfs(int x, int y, int[][] graph, boolean[][] visited, int[] dx, int[] dy, int n) {
        visited[x][y] = true;
        int count = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(graph[nx][ny]==1 && !visited[nx][ny]) {
                    count += dfs(nx,ny,graph,visited,dx,dy,n);
                }
            }
        }
        return count;
    }
}