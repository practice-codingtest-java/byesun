// https://www.acmicpc.net/problem/11053

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * dp[i]는 i번째 수를 마지막 원소로 하는 증가하는 부분 수열의 최대 길이를 의미
 * 이전 인덱스들을 순회하면서 sequence[j] < sequence[i] 조건을 만족하는 경우,
 * dp[i]를 dp[j]+1로 갱신하여 가장 긴 수열을 누적 진행
 * 마지막에는 모든 dp값 중 가장 큰 값을 찾아 출력
 */
public class 가장긴증가하는부분수열11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            sequence[i] = Integer.parseInt(line[i]);
        }
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int length = 0;
        for(int i=0; i<n; i++) {
            length = Math.max(length, dp[i]);
        }
        System.out.println(length);
    }
}
