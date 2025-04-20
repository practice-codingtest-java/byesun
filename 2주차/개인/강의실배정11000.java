package 개인;

/*
 * 1. 시작 시간 배열과 종료 시간 배열을 각각 정렬
 * 2. 종료 시간을 que에 순서대로 넣는다.
 * 3. 시작 시간과 비교를 진행 
 *  - 큐의 값이 시작 시간보다 이하이면 강의실 재사용 가능하므로 que에서 제거
 * 4. 위의 비교가 false으로 그냥 진행되면, 다음 종료 시간을 que에 삽입
 * 5. 마지막으로 que에 사이즈를 반환 ( 강의실 개수 )
 */

import java.util.*;
import java.io.*;

public class 강의실배정11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N];
		int[] T = new int[N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			S[i] = Integer.parseInt(input[0]);
			T[i] = Integer.parseInt(input[1]);
		}
		int result = roomCount(S,T);
		System.out.println(result);
	}

	private static int roomCount(int[] S, int[] T) {
		Arrays.sort(S);
		Arrays.sort(T);
		
		Deque<Integer> que = new ArrayDeque<>();
		que.offer(T[0]);
		
		for(int i=1; i<S.length; i++) {
			if(que.peek() <= S[i]) {
				que.poll();
			}
			que.offer(T[i]);
		}
		return que.size();
	}
}