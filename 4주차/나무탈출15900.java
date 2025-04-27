// https://www.acmicpc.net/problem/15900

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 * 리프 노드까지의 거리의 합을 구한다.
 * 리프 노드까지의 거리의 합이 짝수 이면 Yes, 홀수이면 No을 출력하면 된다.
 * 
 * 리프 노드는 자식 노드가 없는 노드이므로, 인접 노드가 없으면 리프노드이다!!
 * 그 깊이를 합산한다.
 */

public class 나무탈출15900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n - 1; i++){
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        int result = bfs(graph, n);

        if(result % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static int bfs(List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        Deque<int[]> que = new LinkedList<>();
        que.offer(new int[]{1,0});
        visited[1] = true;

        int count = 0;

        while(!que.isEmpty()) {
            int[] current = que.poll();
            int curNode = current[0];
            int curEdge = current[1];

            boolean Leaf = true;

            for(int next : graph.get(curNode)) {
                if(!visited[next]) {
                    visited[next] = true;
                    que.offer(new int[]{next, curEdge + 1});
                    Leaf = false;
                }
            }
            if(Leaf) {
                count += curEdge;
            }
        }
        return count;
    }
}
