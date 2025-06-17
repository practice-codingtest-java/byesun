// https://www.acmicpc.net/problem/2295

import java.io.*;
import java.util.*;

public class 세수의합2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        Set<Integer> twoSum = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                twoSum.add(nums[i] + nums[j]);
            }
        }

        for (int k = N - 1; k >= 0; k--) {
            for (int l = 0; l <= k; l++) {
                int d = nums[k];
                int c = nums[l];
                if (twoSum.contains(d - c)) {
                    System.out.println(d);
                    return;
                }
            }
        }
    }
}
