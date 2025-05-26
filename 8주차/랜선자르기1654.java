// https://www.acmicpc.net/problem/1654
import java.io.*;

/**
 * 나무 자르기 문제와 같다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long K = Long.parseLong(line[0]);
        long N = Long.parseLong(line[1]);
        long[] cables = new long[(int) K];
        for(int i=0; i<cables.length; i++) {
            cables[i] = Long.parseLong(br.readLine());
        }
        long result = solution(K,N,cables);
        System.out.println(result);
    }

    private static long solution(long K, long N, long[] cables) {
        long left = 1;
        long result = 0;
        long right = cables[0];
        for(int i=1; i<cables.length; i++) {
            if(right < cables[i]) right = cables[i];
        }

        while(left <= right) {
            long mid = left + (right - left) / 2;
            long total = 0;

            for(long cable : cables) {
                total += cable / mid;
            }
            if(total >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}