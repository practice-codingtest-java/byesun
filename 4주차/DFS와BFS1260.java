// https://www.acmicpc.net/problem/1260

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 문제에서 인접리스트 형태로 데이터를 생성하여,
 * DFS와 BFS를 구현을 진행
 * 주의 했어야 했던 점 -> 문제에서 정점 번호가 작은 것을 먼저 방문....
 * 인접 리스트를 정렬 진행 이후 DFS와 BFS 결과를 출력력
 */
public class DFS와BFS1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        for (List<Integer> integers : graph) {
            Collections.sort(integers);
        }
        solve(graph, v);
        System.out.println();
        bfs(graph, v);
    }

    private static void solve(List<List<Integer>> graph, int v) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        dfs(graph,visited,v);
    }
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int v) {
        visited[v] =  true;
        System.out.print(v + " ");
        for(int nextVertex : graph.get(v)) {
            if(!visited[nextVertex]) {
                dfs(graph,visited,nextVertex);
            }
        }
    }


    private static void bfs(List<List<Integer>> graph, int v) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Deque<Integer> que = new LinkedList<>();
        que.add(v);
        visited[v] = true;
        while(!que.isEmpty()) {
            int curVertex = que.poll();
            for(int nextVertex : graph.get(curVertex)) {
                if(!visited[nextVertex]) {
                    que.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
            System.out.print(curVertex + " ");
        }
    }
}