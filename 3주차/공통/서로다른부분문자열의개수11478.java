// https://www.acmicpc.net/problem/11478
import java.util.*;
import java.io.*;

/**
 * 문자열의 길이의 1부터 S.length를 더한 배열을 선언
 * hash set 생성 이후 값을 넣고,
 * 마지막에 size()를 반환하면 끝
 */

public class 서로다른부분문자열의개수11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        String S = br.readLine();
        int result = sizeCrossing(S, set);
        System.out.println(result);
    }

    private static int sizeCrossing(String S, HashSet<String> set) {
        for(int i = 0; i< S.length(); i++) {
            for(int j = i+1; j< S.length()+1; j++) {
                set.add(S.substring(i,j));
            }
        }
        return set.size();
    }
}