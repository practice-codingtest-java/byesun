// https://www.acmicpc.net/problem/1325

/**
 * 2를 해킹하면, 2를 신뢰하는 A도 해킹된다.
 * 입력을 받을 때, 1 2 라는 입력이 나오면, 2 -> 1 방향 ??
 * 방향성을 같는 BFS/DFS를 구현
 * 시작 지점이 되는 노드들을 메서드에 넣어서 가장 만힝 해킹 되는 컴퓨터 번호를 출력
 * 해킹의 컴퓨터의 개수가 같으면 오름차순으로 출력을 한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 효율적인해킹1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            graph.get(e).add(s);
        }
        int[] arr = bfs(graph);
        resultPrint(arr);
    }
    private static int[] bfs(List<List<Integer>> graph) {
        int n = graph.size() - 1;
        int[] result = new int[n+1];

        for(int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n+1];
            Deque<Integer> que = new ArrayDeque<>();
            que.add(i);
            visited[i] = true;
            int count = 1;
            while(!que.isEmpty()) {
                int curVertex = que.poll();
                for(int nextVertex : graph.get(curVertex)) {
                    if (!visited[nextVertex]) {
                        visited[nextVertex] = true;
                        que.add(nextVertex);
                        count++;
                    }
                }
            }
            result[i] = count;
        }
        return result;
    }

    private static void resultPrint(int[] arr) {
        StringBuilder sb= new StringBuilder();
        int maxNum = 0;
        for(int i=0; i<arr.length; i++) {
            maxNum = Math.max(maxNum, arr[i]);
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == maxNum) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}