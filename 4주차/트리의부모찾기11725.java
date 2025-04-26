// https://www.acmicpc.net/problem/11725
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS으로 문제를 해결
 * 구현 이후 부모에 대한 데이터를 저장해야 하므로,
 * 배열을 따로 선언 후, 배열[자식] = [부모] 형식으로 데이터를 저장
 * 배열의 사이즈를 생각하여 결과를 출력력
 */
public class 트리의부모찾기11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        int[] result = bfs(graph);
        for(int i=2; i<n+1; i++) {
            System.out.println(result[i]);
        }
    }
    private static int[] bfs(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        int[] result = new int[n];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = true;
        while(!que.isEmpty()) {
            int curVertex = que.poll();
            for(int nextVertex : graph.get(curVertex)) {
                if(!visited[nextVertex]) {
                    result[nextVertex] = curVertex;
                    que.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }
        return result;
    }
}