// https://www.acmicpc.net/problem/21736

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 인접 행렬로 값을 받고 I의 위치를 x축과 y축을 파악
 *  인접행렬과 방문 배열과, x축, y축을 bfs메서드로 넘긴다.
 *  상 하 좌 우를 방문 하면서 P(사람)을 찾는다.
 *  사람을 찾을 경우 마다 count++, 사람이 없는 경우 그냥 count를 리턴
 *  결과를 출력하는 메서드에 count 값을 넣어 결과를 출력한다.
 */
public class 헌내기는친구가필요해21736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<List<Character>> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        int x=0;
        int y=0;
        for(int i=0; i<n; i++) {
            char[] line = br.readLine().toCharArray();
            list.add(new ArrayList<>());
            for(int j=0; j<m; j++) {
                list.get(i).add(line[j]);
                if(line[j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }
        int count = bfs(list,visited,x,y);
        printResult(count);
    }

    private static int bfs(List<List<Character>> list, boolean[][] visited, int x, int y) {
        int count = 0;
        Deque<int[]> que = new LinkedList<>();
        int n = list.size();
        int m = list.get(0).size();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        que.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int curX = current[0];
            int curY = current[1];

            for(int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && n > nx && m > ny) {
                    if(!visited[nx][ny]) {
                        char next = list.get(nx).get(ny);
                        if(next == 'O' || next == 'P') {
                            visited[nx][ny] = true;
                            if(next == 'P') count++;
                            que.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        return count;
    }

    private static void printResult(int count) {
        if(count > 0) {
            System.out.println(count);
        } else {
            System.out.println("TT");
        }
    }
}
