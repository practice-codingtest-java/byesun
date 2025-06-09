// https://www.acmicpc.net/problem/11501

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 뒤에서부터 보면 앞의 값이 현재 최고가 보다 작으면 이익이 단순 계산이 가능
 * arr[i] < maxPrice 면 -> profit += (maxPrice - arr[i])
 * 아니면 maxPrice = arr[i] 새로운 max 값을 갱신해야 함
 *
 */
public class 주식11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }
            sb.append(totalProfit(arr)+"\n");
        }
        System.out.println(sb);
    }
    private static long totalProfit(int[] arr) {
        long profit = 0;
        int maxPrice = 0;

        for(int i=arr.length-1; i >= 0; i--) {
            if(arr[i] < maxPrice) {
                profit += (maxPrice - arr[i]);
            } else {
                maxPrice = arr[i];
            }
        }
        return profit;
    }

}
