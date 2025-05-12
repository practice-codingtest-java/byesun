// https://www.acmicpc.net/problem/2579

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제에서 제약 조건은 세 계단 연속 밟으면 안됨
 *
 * 각 계단까지 도달할 수 있는 최대 점수를 dp[i]에 저장
 * 세 계단을 연속으로 밟을 수 없다는 조건을 고려하여 i-2 에서 한 번에 올라오거나,
 * i-3에서 한 계단을 밝고 올라오는 두 가지 경우 중 최대값을 선택한다.
 * 또한, 계단 번호를 1부터 사용하고, 초기값,dp[1],dp[2]을 따로 처리하여 점화식을 적용
 */
public class 계단오르기2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n+1];
        for(int i=1; i<=n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n+1];
        dp[1] = stairs[1];
        if(n >= 2) { dp[2] = stairs[1] + stairs[2]; }
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }
        System.out.println(dp[n]);
    }
}
