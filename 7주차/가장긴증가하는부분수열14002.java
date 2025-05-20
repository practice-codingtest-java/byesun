// https://www.acmicpc.net/problem/14002

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 점화식
 * - dp[i] = i 번쨰 원소를 마지막으로 하는 lis의 길이
 * - dp[i] = max(dp[j]+1),j<i이고 sequence[j] < sequence[i]인 경우
 * 추적용 배열 추가
 * - prev[i] = dp[i]가 업데이트 될 이전 index를 저장
 * lis를 역추적하기 위해 필요
 */
public class 가장긴증가하는부분수열14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] sequence = new int[A];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<A; i++) {
            sequence[i] = Integer.parseInt(line[i]);
        }
        int[] dp = new int[A];
        int[] prev = new int[A];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1;
        int lastIndex = 0;

        for(int i=0; i<A; i++) {
            for(int j=0; j<i; j++) {
                if(sequence[i] > sequence[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        int index = lastIndex;
        while(index != -1) {
            stack.push(sequence[index]);
            index = prev[index];
        }
        System.out.println(maxLength);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
