// https://www.acmicpc.net/problem/9466

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 해당 배열을 입력값을 받을때, 인덱스 번호가 해당 학생의 수이고, 인덱스의 값이 목표 숫자이다.
 * 해당 사이클이 만들어지면 팀으로 구성이 되었다고 볼 수 있다.
 * 예외의 경우는 해당 인덱스가 자기 자신의 목표 숫자를 가지는 경우도 사이클이 완성되었다고 볼 수 있다.
 * 
 * 사이클이 존재할 떄 마다 count++를 하여 진행
 * 학생의 수에서 사이클의 수를 뺴여 결과를 출력력
 */
public class 팀프로젝트9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] graph = new int[n+1];
            boolean[] visited = new boolean[n+1];
            boolean[] finished = new boolean[n+1];
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    count += dfs(graph,visited,finished,i);
                }
            }
            sb.append(n - count).append("\n");
        }
        System.out.println(sb);
    }
    private static int dfs(int[] graph, boolean[] visited, boolean[] finished, int i) {
        visited[i] = true;
        int next = graph[i];
        int count = 0;
        if(!visited[next]) {
            count += dfs(graph,visited,finished,next);
        } else if(!finished[next]) {
            for (int j = next; j != i; j = graph[j]) {
                count++;
            }
            count++;
        }
        finished[i] = true;
        return count;
    }
}