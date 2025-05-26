// https://www.acmicpc.net/problem/2110

import java.io.*;
import java.util.*;
/**
 * 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1,...,xn이고 집 여러개가 같은 좌표를 가지는 일은 없다.
 * 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에서 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를
 * 가능한 크게 하여 설치하려고 한다.
 * C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
 *
 * 첫쨰 줄에 집의 개수 N과 공유기의 개수 C이 하나 이상의 빈 칸을 사이에 두고 주어진다.
 * 둘째 줄에는 집의 좌표를 나타내는 x가 한 줄에 하나씩 주어진다.
 *
 * 공유기를 1,4,8 또는 1,4,9에 설치하면 가장 인접한 두 공유기 사이의 거리는 3ㅣㅇ고, 이 거리보다 크게 공유기를 3개 설치할 수 없다.
 *
 * left = 한칸은 최소 간격 (설명란)
 * right = 가장 먼집에서 가까운 집의 거리를 마이너스
 *
 * 설치 가능한 공유기 개수 세기
 * 만약 C개 이상 설치 가능 -> 거리 늘려보기
 * 아니라면 거리 줄이기
 */
public class 공유기설치2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long N = Long.parseLong(line[0]);
        long C = Long.parseLong(line[1]);
        long[] modems = new long[(int) N];
        for(int i=0; i<(int)N; i++) {
            modems[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(modems);
        long left = 1;
        long right = modems[modems.length - 1] - modems[0];
        while(left <= right) {
            long mid = left + (right - left) / 2;
            int count = 1;
            long lastModems = modems[0];

            // 이전 공유기 위치와 거리 차이가 mid 이상이면 공유기 설치
            for(int i=1; i<modems.length; i++) {
                if(modems[i] - lastModems >= mid) {
                    count++;
                    lastModems = modems[i];
                }
            }

            // 설치 개수로 이분 탐색 진행
            if(count >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
