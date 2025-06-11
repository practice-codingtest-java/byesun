// https://www.acmicpc.net/problem/1647

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 도시분할계획1647 {
    static int[] parent;

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;
        parent[y] = x;
        return true;
    }
    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        List<int[]> list = new ArrayList<>();

        for(int i=0; i<M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);
            list.add(new int[]{a,b,weight});
        }
        list.sort(Comparator.comparingInt(o -> o[2]));

        int total = 0;
        int max = 0;

        for (int[] i : list) {
            int a = i[0];
            int b = i[1];
            int cost = i[2];

            if(union(a,b)) {
                total += cost;
                max = cost;
            }
        }
        System.out.println(total - max);
    }

}