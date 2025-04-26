// https://www.acmicpc.net/problem/1012
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 입력 값을 2차원 인접 리스트로 생성한다.
 * 인접 리스트를 가지고 BFS를 돌아 탐색한다.
 * 여기에서 특정 노드에서 시작할 때, 이 시작 노드에서 얼마나 탐색이 진행이 되었는지를 count 한다.
 */
public class 바이러스2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=computers; i++) {
            graph.add(new ArrayList());
        }
        for(int i=0; i<edges; i++) {
            String[] node = br.readLine().split(" ");
            int s = Integer.parseInt(node[0]);
            int e = Integer.parseInt(node[1]);

            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        int result = bfs(graph);
        System.out.println(result);
    }
    private static int bfs(List<List<Integer>> graph) {
        int count = 0;
        Deque<Integer> que = new ArrayDeque();
        int n = graph.size();
        boolean[] visited = new boolean[n];
        que.add(1);
        visited[1] = true;
        while(!que.isEmpty()) {
            int curVertex = que.poll();
            for(int nextVertex : graph.get(curVertex)) {
                if(!visited[nextVertex]) {
                    count++;
                    que.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }
        return count;
    }
}
