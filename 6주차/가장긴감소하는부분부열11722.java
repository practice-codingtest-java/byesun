// https://www.acmicpc.net/problem/11722

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장긴감소하는부분부열11722 {
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
                if(sequence[j] > sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
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
