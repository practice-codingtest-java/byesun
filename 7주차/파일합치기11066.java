// https://www.acmicpc.net/problem/11066

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * dp 점화식 설계
 * - dp[i][j] : i번 파일부터 j번 파일까지 하나로 함치는 데 드는 최소 비용
 * - sum[i][j] : i번부터 j번까지 파일 크기의 누적합
 * => dp[i][j] = min(dp[i][k] + dp[k+1][j] + sum[i][j])
 *      - dp[i][k] + dp[k+1][j] : 두 구간으로 나눈 뒤 각각을 합치는 최소 비용
 *      - sum[i][j] : 나눠진 두 구간을 하나로 합칠 때 드는 비용
 * 누적합이 있어야 sum[i][j]를 빠르게 계산할 수 있음
 * sum[i] = files[0] + files[1] + ... + files[i]
 * totalSum = sum[j] - sum(i-1);
 */
public class 파일합치기11066 {
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int[] files = new int[k];
            String[] line = br.readLine().split(" ");
            for(int i=0; i<k; i++) {
                files[i] = Integer.parseInt(line[i]);
            }
            sum = new int[k];
            sum[0] = files[0];
            for(int i=1; i<k; i++) {
                sum[i] = sum[i-1] + files[i];
            }

            dp = new int[k][k];
            for(int len=2; len<=k; len++) {
                for (int i = 0; i <= k - len; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int l = i; l < j; l++) {
                        int value = dp[i][l] + dp[l+1][j] + getSum(i,j);
                        dp[i][j] = Math.min(dp[i][j], value);
                    }
                }
            }
            sb.append(dp[0][k-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int getSum(int i, int j) {
        return sum[j] - (i > 0 ? sum[i - 1] : 0);
    }
}
