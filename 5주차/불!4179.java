// https://www.acmicpc.net/problem/4179

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * # : 벽
 * . : 지나갈 수 있는 공간
 * J : 지훈이의 미로에서의 초기위치 ( 지나갈 수 있는 공간 )
 * F : 불이 난 공간
 *
 * 불과 지훈이는 1개로 고정 (XXXXX)
   *
 * 1. 처음으로 BFS를 통해서 불의 이동시간을 알아낸다.
 * 2. 지훈이의 이동 시간을 알아 내는 것과 동시에 탈출이 불가능한지 가능한지 알아본다.
 * 3. 지훈이의 이동 시간과 불의 이동시간을 동시에 비교하여 벽에 맞다아 탈출하는 조건과 불이 지훈이를 먹어버리는 조건을 선언한다.
 * 4. 벽에 맞다으면 personTime의 시간을 리턴하여 결과를 출력한다.
 * 5. 불에 먹히거나 탈출구가 없다면, -1를 리턴하여 불가능을 출력한다.
 *
 * 불이 여러개 일수도 있는데 난 왜 1개로 생각을 했지...?
 * 
 * 시작하는 위치를 que를 이용하여 입력값을 받아서 여러개 입력 값을 대비하여 진행
 * 구하는 로직의 위와 동일
 * 탈출 직전 칸에서 한 컨 더 이동 했으므로 마지막에 + 1
 *
 */
public class 불!4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[][] fireTime = new int[R][C];
        int[][] personTime = new int[R][C];
        for (int[] row : fireTime) Arrays.fill(row, -1);
        for (int[] row : personTime) Arrays.fill(row, -1);

        Queue<int[]> fireQue = new ArrayDeque<>();
        Queue<int[]> personQue = new ArrayDeque<>();

        char[][] graph = new char[R][C];

        int[] personStart = new int[2];
        int[] fireStart = new int[2];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = line.charAt(j);
                if (graph[i][j] == 'J') {
                    personQue.offer(new int[]{i,j});
                    personTime[i][j] = 0;
                }
                if (graph[i][j] == 'F') {
                    fireQue.offer(new int[]{i,j});
                    fireTime[i][j] = 0;
                }
            }
        }
        fireBFS(graph, fireTime, fireQue);
        int result = personBFS(graph,fireTime,personTime,personQue);
        if(result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }
    private static void fireBFS(char[][] graph, int[][] fireTime, Queue<int[]> fireQue) {
        int R = graph.length;
        int C = graph[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!fireQue.isEmpty()) {
            int[] current = fireQue.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(graph[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;
                fireTime[nx][ny] = fireTime[cx][cy] + 1;
                fireQue.offer(new int[]{nx, ny});
            }
        }
    }
    private static int personBFS(char[][] graph, int[][] fireTime, int[][] personTime, Queue<int[]> personQue) {
        int R = graph.length;
        int C = graph[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!personQue.isEmpty()) {
            int[] current = personQue.poll();
            int cx = current[0];
            int cy = current[1];
            if(cx == 0 || cy == 0 || cx == R -1 || cy == C -1) {
                return personTime[cx][cy] + 1;
            }
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(graph[nx][ny] == '#' || personTime[nx][ny] != -1) continue;
                if(fireTime[nx][ny] != -1 && fireTime[nx][ny] <= personTime[cx][cy] + 1) continue;

                personTime[nx][ny] = personTime[cx][cy] + 1;
                personQue.offer(new int[]{nx,ny});
            }
        }
        return -1;
    }
}