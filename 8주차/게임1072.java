// https://www.acmicpc.net/problem/1072

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이긴 게임  횟수를 전체 게임 횟수로 나눈다.
 * 결과를 100으로 곱하여 승률을 백분율로 나타낸다. ( 소수점은 버린다. )
 * 승률 = ( 이긴 횟수 / 전체 게임 횟수 ) * 100
 * 
 * int 형으로 작성 시 right의 값에 의해 연산 중 오버플로가 발생하게 된다.
 * 이를 방식하기 위해 int 형보다 큰 범위의 정수형인 long 형을 이용하면 오버플로우 없이 정상 작동 합니다.
 */
public class 게임1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long X = Long.parseLong(input[0]);
        long Y = Long.parseLong(input[1]);
        long victory_percent = Y * 100 / X;

        if(victory_percent >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1000000000;
        long result = -1;

        while(left <= right) {
            long mid = (left + right) / 2;
            long new_percent = ((Y + mid) * 100) / (X + mid);

            if(new_percent > victory_percent) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
