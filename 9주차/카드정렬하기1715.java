// https://www.acmicpc.net/problem/1715

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 묶음들을 우선순위 큐에 넣는다.
 * 큐에서 가장 작은 두 묶음을 꺼낸다. ( 자동 정렬 )
 * 합쳐서 비교 횟수에 더하고, 합친 묶음을 다시 큐에 넣는다.
 * 큐에 하나만 날을 떄까지 반복을 진행한다.
 *
 * 가장 작은 묶음
 * 두 번째로 작은 묶음
 * 합치는 데 필요한 비교 횟수 ( 가작 작은 묶음 + 두번째로 작은 묶음 )
 * 총 비교 횟수 누적 (결과를 구하기 위해 결과에 비교 횟수 +)
 * 합친 묶음을 다시 큐에 넣은 (다음 비교를 위해) -> 우선순위 큐에 넣어서 자동 정렬
 * 1개가 남으면 끝
 */
public class 카드정렬하기1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            que.offer(Integer.parseInt(br.readLine()));
        }
//        System.out.println(que);
        int result = 0;
        while(que.size() > 1) {
            int cur = que.poll();
            int next = que.poll();
            int sum = cur + next;
            result += sum;
            que.offer(sum);
        }
        System.out.println(result);
    }
}
