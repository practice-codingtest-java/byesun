// https://www.acmicpc.net/problem/22860

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 파일의 구조와 해당 파일의 경로를 입력 받는다.
 * 파일의 구조와 파일 경로가 들어올 때 마다 bfs 메서드에 넘긴다.
 *
 *  bfs 메서드를 통해 해당 폴더에서 시작하여 그 하위 폴더들을 모두 탐색진행
 *      - 파일이면 파일 이름을 set에 저장한다.
 *      - 파일의 총 개수는 만난 파일마다 count++를 진행
 *
 *  최종적으로 set.size()와 count를 배열로 리턴한다.
 *
 */
public class 폴더정리(small)22860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, List<String[]>> graph = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child = st.nextToken();
            String type = st.nextToken();

            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(new String[]{child, type});
        }

        int q = Integer.parseInt(br.readLine());
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = br.readLine();
        }
        for (String query : queries) {
            int[] bfs = bfs(graph, query);
            sb.append(bfs[0]).append(" ").append(bfs[1]).append("\n");
        }
        System.out.println(sb);
    }
    private static int[] bfs(Map<String,List<String[]>> graph,String queries) {
        String[] paths = queries.split("/");
        String start = paths[paths.length - 1];
        Queue<String> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int count = 0;
        que.offer(start);
        while (!que.isEmpty()) {
            String current = que.poll();
            if(!graph.containsKey(current)) continue;
            for (String[] s : graph.get(current)) {
                String name = s[0];
                String type = s[1];

                if(type.equals("0")) {
                    visited.add(name);
                    count++;
                } else {
                    que.offer(name);
                }
            }
        }
        return new int[]{visited.size(), count };
    }
}