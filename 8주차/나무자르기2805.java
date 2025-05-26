// https://www.acmicpc.net/problem/2805
import java.io.*;

/**
 * 나무의 수 N, 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다.
 * Long으로 변수를 선언해야 오버플로가 발생하지 않는다. (int 형으로 처리 시 오버플로 발생)
 * 나무의 높이가 주진다.
 *
 * total은 총 나무 길이
 * total을 중간..중간..중간..중간.. 자르다가 left가 right보다 같거나 커지면, 종료
 * 위의 과정을 거치는 동안 totla >= M인 경우이면 결과 변수를 mid값으로 초기화 하면서 진행
 */
public class 나무자르기2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        long N = Long.parseLong(line1[0]);
        long M = Long.parseLong(line1[1]);
        long[] trees = new long[(int) N];
        String[] line2 = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            trees[i] = Long.parseLong(line2[i]);
        }
        long result = solution(N,M,trees);
        System.out.println(result);
    }
    private static long solution(long N, long M, long[] trees) {
        long left = 0;
        long result = 0;
        long right = trees[0];
        for(int i=1; i<N; i++) {
            if(right < trees[i]) {
                right = trees[i];
            }
        }

        while(left <= right) {
            long mid = left + (right - left) / 2;
            long total = 0;

            for(long tree : trees) {
                if(tree - mid > 0) {
                    total += tree - mid;
                }
            }
            // System.out.println(total);

            if(total >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
