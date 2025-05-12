// https://www.acmicpc.net/problem/2294

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 동전의 개수는 상관이 없다. 현재 주어지는 동전의 값만 생각하고 동전의 개수는 무제한이다
 * 하지만 이 곳에서 최소한의 동전으로 k값이 될 수 있도록 해야한다.
 *
 */
public class 동전2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int coin : coins) {
            for(int i=coin; i<=k; i++) {
                dp[i] = Math.min(dp[i],dp[i-coin] + 1);
                System.out.println(dp[i]);
            }
        }
        System.out.println(dp[k] == k + 1 ? -1 : dp[k]);
    }
}