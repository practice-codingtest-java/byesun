// https://www.acmicpc.net/problem/1541

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * - 이후 나오는 값들을 묶으면 최솟 값을 구할 수 있음
 * 그러면 -를 기준으로 일단 문자를 분리
 * +가 딸린 문자들을 처리해주는 매서드를 선언하여 계산을 진행
 * 처음 시작하는 값은 음수가 아니므로 시작 결과에 반환을 하고
 * 이후 아노는 - 이후의 문자들의 합을 결과 변수에서 -를 진행하면 최솟값이 나온다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] minus = input.split("-");
//        for (String s : minus) {
//            System.out.println(s);
//        }
        int result = sum(minus[0]);
        for(int i=1; i<minus.length; i++) {
            result -= sum(minus[i]);
        }
        System.out.println(result);
    }
    private static int sum(String arr) {
        String[] plus = arr.split("\\+");
//        for (String s : plus) {
//            System.out.println(s);
//        }
        int sum = 0;
        for(int i=0; i<plus.length; i++) {
            sum += Integer.parseInt(plus[i]);
        }
        return sum;
    }

}
