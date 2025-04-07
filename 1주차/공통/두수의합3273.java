import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두수의합3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int X = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int maxValue = X;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            maxValue = Math.max(maxValue,arr[i]);
        }
        boolean[] visited = new boolean[maxValue+1];

        int count = 0;
        for (int i = 0; i < N; i++) {
            int target = X - arr[i];
            if(target > 0 && visited[target]) {
                count++;
            }
            visited[arr[i]] = true;
        }
        System.out.println(count);
    }
}