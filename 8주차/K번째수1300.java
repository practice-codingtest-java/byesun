// https://www.acmicpc.net/problem/1300
import java.io.*;

/**
 * 1부터 N x N까지 범위에서 "k번째로 작은 수"를 찾으면 될거 같다.
 * left를 1, right를 k로 잡고 이분 탐색 진행
 * mid이하의 개수를 세서 k와 비교
 * 개수가 k개 이상이면 mid가 정답 -> 반복하여 최종 mid를 구하여 left를 반환
 */

public class K번째수1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = (long) k;

        while(left <= right) {
            long mid = left + (right-left) / 2;
            long count = 0;
            for(int i=1; i<=N; i++) {
                count += Math.min(mid/i, N);
            }
            if(count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
