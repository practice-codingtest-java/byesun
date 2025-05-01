// https://www.acmicpc.net/problem/7576

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 벽 조건이랑, 1이 여러개 일 경우 같이 처리하는 방법을 알아야 할거 같은데 그냥 1의 개수에 맞춰서
 *
 * 전체 맵을 순회하면서 1인 좌표를 모두 큐에 넣음
 * BFS로 큐를 순회하면서 0인 좌표를 1로 바꾸고 날짜(+1)를 기록
 * BFS 종료 후 맵에 0이 남아 있다면 -1 출력, 아니라면 최댓값 출력
 */
public class 토마토7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        List<int[]> startPoint = new ArrayList<>();
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                list.get(i).add(Integer.parseInt(line[j]));
                if(line[j].equals("1")) {
                    startPoint.add(new int[]{i,j});
                }
            }
        }
        int[][] resultList = bfs(list, startPoint);
        int result = resultPrint(resultList,list);
        System.out.println(result);
    }
    private static int[][] bfs(List<List<Integer>> list, List<int[]> startPoint) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = list.size();
        int m = list.get(0).size();
        Deque<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] days = new int[n][m];
        for (int[] point : startPoint) {
            int x= point[0];
            int y= point[1];
            que.offer(new int[]{x,y});
            visited[x][y] = true;
        }
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(!visited[nx][ny] && list.get(nx).get(ny) == 0) {
                        list.get(nx).set(ny,1);
                        que.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        days[nx][ny] = days[cx][cy] + 1;
                    }
                }
            }
        }
        return days;
    }

    private static int resultPrint(int[][] resultList,List<List<Integer>> list) {
        int n = resultList.length;
        int m = resultList[0].length;
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(list.get(i).get(j) == 0 && resultList[i][j] == 0) {
                    return -1;
                }
                count = Math.max(count,resultList[i][j]);
            }
        }
        return count;
    }
}