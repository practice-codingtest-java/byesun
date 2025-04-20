// https://www.acmicpc.net/problem/1919

import java.util.*;
import java.io.*;

public class 에너그램만들기1919 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");
        Arrays.sort(str1);
        Arrays.sort(str2);
        int result = solution(str1,str2);
        System.out.println(result);
    }
    private static int solution(String[] str1, String[] str2) {
        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        for(String s : str1) {
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        for(String s : str2) {
            if(!map.containsKey(s) || map.get(s) == 0) {
                count++;
            } else {
                map.put(s,map.get(s)-1);
            }
        }
        for (int value : map.values()) {
            count += value;
        }
        return count;
    }
}
