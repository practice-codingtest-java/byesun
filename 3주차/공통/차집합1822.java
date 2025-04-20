// https://www.acmicpc.net/problem/1822

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 차집합1822 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nArr = new int[n];
        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<m; i++) {
            set.add(mArr[i]);
        }
        for(int i=0; i<n; i++) {
            if(!set.contains(nArr[i])) {
                list.add(nArr[i]);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
    
}
