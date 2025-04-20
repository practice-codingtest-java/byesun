// https://www.acmicpc.net/problem/1269
import java.util.*;
import java.io.*;

public class 대칭차집합1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(str2[i]);
        }
        int result = consolidation(arr1,arr2);
        System.out.println(result);
    }

    private static int consolidation(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int arr : arr1) {
            set.add(arr);
        }
        for(int arr : arr2) {
            if(!set.contains(arr)) {
                set.add(arr);
            } else {
                set.remove(arr);
            }
        }
        return set.size();
    }
}
