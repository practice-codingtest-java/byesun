// https://www.acmicpc.net/problem/2170

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 입력 값을 start와 end로 받은 다음에 start의 기준으로 정렬을 진행한다.
 * 그리고 현재의 start와 end의 값을 가지고
 * 현재 end의 값이 다음 start 값보다 작거나 같은 경우에
 *      현재 start와 end의 길이의 범위에 포함되어 있으므로, 현재 end의 값을 현재 end와 다음 end 중 더 큰 값을 반환
 * 아닐 경우
 *      범위에 포함이 되어 있지 않아서 total 변수에 현재 end - 현재 start의 값을 넣어주고 현재의 값들을 다음 값으로 업데이트 해준다.
 * 이후 마지막의 길이까지 더해주고 나면 결과
 */
public class 선긋기2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        int result = 0;
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            list.add(new int[]{start,end});
        }
        list.sort((o1,o2) -> Integer.compare(o1[0],o2[0]));
//        for (int[] ints : list) {
//            System.out.println(Arrays.toString(ints));
//        }
        int curStart = list.get(0)[0];
        int curEnd = list.get(0)[1];
        for(int i=1; i<list.size(); i++) {
            int[] next = list.get(i);
            if(next[0] <= curEnd) {
                curEnd = Math.max(next[1], curEnd);
            } else {
                result += curEnd - curStart;
                curStart = next[0];
                curEnd = next[1];
            }
        }
        result += curEnd - curStart;
        System.out.println(result);
    }
}
