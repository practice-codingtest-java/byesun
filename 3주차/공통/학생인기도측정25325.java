// https://www.acmicpc.net/problem/25325
import java.util.*;
import java.io.*;

public class 학생인기도측정25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for(String s : input) {
            map.put(s,0);
        }

        for(int i = 0; i < n; i++) {
            String[] popularityArr = br.readLine().split(" ");
            for(String s : popularityArr) {
                map.put(s,map.get(s)+1);
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> {
            int temp = Integer.compare(map.get(b),map.get(a));
            if(temp == 0) {
                return a.compareTo(b);
            }
            return temp;
        });

        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
    }
}