// https://www.acmicpc.net/problem/1920
import java.io.*;
import java.util.*;

/**
 * N의 배열과, M의 배열을 각각 만든다.
 * N과 M을 비교하여 겹치는 값을 set에 넣는다.
 * 0으로 초기화 된 M이 사이즈 배열에 새로운 배열에 인덱스 위치에 1을 넣는다.
 * 반복하여 값을 꺼낸다.
 */
public class 수찾기1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] n_arr = new String[N];
        n_arr = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());
        String[] m_arr = new String[M];
        m_arr = br.readLine().split(" ");

        int[] solution = solution(n_arr, m_arr);
        for (int i : solution) {
            System.out.println(i);
        }
    }
    private static int[] solution(String[] n_arr, String[] m_arr) {
        Set<String> set = new HashSet<>();
        int[] result = new int[m_arr.length];
        for (int i = 0; i < n_arr.length; i++) {
            set.add(n_arr[i]);
        }
        for(int i = 0; i < m_arr.length; i++) {
            if(set.contains(m_arr[i])) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}