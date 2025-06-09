// https://www.acmicpc.net/problem/1092
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 정렬하고
 * 매 분 마다 각 크레인이 가장 무거운 들 수 있는 박스를 옮기게 시뮬레이션
 * 최소 시간 구하기
 * 
 * 박스를 리스트에 넣고 리스트에서 박스가 빌 때까지 반복
 *      각 크레인이 하나씩 박스를 확인
 *          옮길 수 있다면 제거하고 다음 크레인을 선택하기 위해 craneIndex++;
 *          못 옮기면 다음 박스로 넘어가기 위해 boxIndex++;
 *      여기까지 오면 result++;
 * 반복문이 끝나고 result를 출력
 */
public class 배1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        String[] input1 = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            cranes[i] = Integer.parseInt(input1[i]);
        }

        int M  = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        List<Integer> boxes = new ArrayList<>();
        for(int i=0; i<M; i++) {
            boxes.add(Integer.parseInt(input2[i]));
        }
        Arrays.sort(cranes, Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());
        if(cranes[0] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }
        int result = 0;
        while(!boxes.isEmpty()) {
            int craneIndex = 0;
            int boxIndex = 0;
            while(craneIndex < N && boxIndex < boxes.size()) {
                if(cranes[craneIndex] >= boxes.get(boxIndex)) {
                    boxes.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }
            result++;
        }
        System.out.println(result);
    }
}