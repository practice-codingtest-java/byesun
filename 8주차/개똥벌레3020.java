// https://www.acmicpc.net/problem/3020
import java.io.*;
import java.util.*;

/**
 * 개똥벌레 한 마리가 장애물(석순과 종유석)로 가득찬 동굴에 들어갔다.
 *
 * 동굴의 크기와 높이, 모든 장애물의 크기가 주어진다. 이때, 개똥 벌레가 파괴해야하는 장애물의 최솟값과
 * 그러한 구간이 총 몇 개 있는지 구하는 프로그램을 작성하시오.
 *
 * 이분탐색을 모든 구간을 진행해야 한다.
 *
 * 각 높이별로 부딪히는 장애물 개수를 계산하기 위해서는
 *      - 석순은 높이 이상인 것을 찾아야 함
 *      - 종유석은 동굴의 높이 - 높이 + 1 을 찾아야 함
 * 위의 두개의 데이터를 매개변수로 넘김
 *
 *  total은 부딪힌 장애물의 개수
 *  
 */
public class 개똥벌레3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int H = Integer.parseInt(line[1]);
        int[] up = new int[N/2];
        int[] down = new int[N/2];
        for(int i=0; i<N/2; i++) {
            up[i] = Integer.parseInt(br.readLine());
            down[i] = Integer.parseInt(br.readLine());
        }
        int[] result = solution(N,H,up,down);
        System.out.println(result[0] + " " + result[1]);
    }
    private static int[] solution(int N, int H, int[] up, int[] down) {
        Arrays.sort(up);
        Arrays.sort(down);

        int minObstacles = Integer.MAX_VALUE;
        int count = 0;

        for(int i=1; i<=H; i++) {
            int upObstacles = up.length - solve(up,i);
            int downObstacles = down.length - solve(down,H-i+1);

            int total = upObstacles + downObstacles;

            if(total < minObstacles) {
                minObstacles = total;
                count = 1;
            } else if(total == minObstacles) {
                count++;
            }
        }
        int[] result = new int[]{minObstacles,count};
        return result;
    }
    private static int solve(int[] arr, int k) {
        int left = 0;
        int right = arr.length;
        while(left < right) {
            int mid = left + (right-left) / 2;
            if(arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid; // mid를 지나서 아래로 내려갈 수 있다. 그래서 right = mid
            }
        }
        return left;
    }
}
