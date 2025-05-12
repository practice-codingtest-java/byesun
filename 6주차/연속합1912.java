// https://www.acmicpc.net/problem/1912

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 점화식
 * 초기 값 세팅 -> dp[0] = sequence[0] , int max = dp[0]을 초기값으로 세팅을 해둔다.
 * 점화식은 i가 1부터 n까지 반복을 할 떄, dp[i] = Math.max(dp[i-1] + sequence[i], sequence[i])
 *      을 세워두면 연속된 값을 찾아 그 중 최대값을 찾아 dp[i]에 반환을 한다.
 * dp[i]의 배열에서 최대값을 변수 max에 반환하여 max를 출력한다.
 */
public class 연속합1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            sequence[i] = Integer.parseInt(line[i]);
        }
        int[] dp = new int[n];
        dp[0] = sequence[0];
        int max = dp[0];
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1] + sequence[i], sequence[i]);
        }
        for(int i=0; i<n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
