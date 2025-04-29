// https://www.acmicpc.net/problem/7562

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 첫 쨰줄 i값이 i X i 배열
 * 0,0 을 기준으로 나이트가 이동할 수 있는 경로 8가지
왼쪽 위
(-1, -2) / (-2, -1)

왼쪽 아래
(-2, 1) / (-1, 2)

오른쪽 위
(1, -2) / (2, -1)

오른쪽 아래
(1, 2) / (2, 1) 
 */

public class 나이트의이동7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        for(int i=0; i<N; i++) {
            int I = Integer.parseInt(br.readLine());
            String[] firstLine = br.readLine().split(" ");
            String[] lastLine = br.readLine().split(" ");

            int startX = Integer.parseInt(firstLine[0]);
            int endX = Integer.parseInt(lastLine[0]);
            int startY = Integer.parseInt(firstLine[1]);
            int endY = Integer.parseInt(lastLine[1]);

            result[i] = bfs(I,startX,endX,startY,endY);
        }
        for (int i : result) {
            System.out.println(i);
        }
    }
    private static int bfs(int I, int startX, int endX, int startY, int endY) {
        int[] dx = {-2,-1,-2,-1,1,2,1,2};
        int[] dy = {-1,-2,1,2,-2,-1,2,1};
        boolean[][] visited = new boolean[I][I];
        Deque<int[]> que = new LinkedList<>();
        que.add(new int[]{startX,startY,0});
        visited[startX][startY] = true;
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int curX = current[0];
            int curY = current[1];
            int count = current[2];
            if(curX == endX && curY == endY) {
                return count;
            }
            for(int i=0; i<8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx >= 0 && ny >= 0 && nx < I && ny < I && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx,ny,count+1});
                }
            }
        }
        return 0;
    }
}