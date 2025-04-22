// https://www.acmicpc.net/problem/9375
import java.io.*;
import java.util.*;

/**
 * 종류별로 선택할 수 있는 경우의 수 = 해당 종류의 옷 개수 + 1
 * 모든 종류에 대해 곱하고, 마지막에 아무것도 입지 않은 경우 1을 뺴면 된다?
 */

  /**
  * 정리
  * HashMap을 선언하여 Key에 옷 종류, Value에 옷 개수 할당 ( hashmap의 getOrDefault 메서드를 사용 )
  * 경우의 수를 계산
  *  - 종류별 경우의 수는 해당 옷 개수 + 1
  *     - + 1은 해당 종류를 안 입는 경우
  *  - 모든 종류를 곱해서 종류별 경우의 수를 구함
  * 
  * 아무것도 입지 않은 경우가 있기 때문에 결과에 -1를 하여 리턴
  */

public class 패션왕신해빈9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            String[] str = new String[m];
            for(int j=0; j<m; j++){
                str[j]= br.readLine();
            }
            result[i] = solution(str);
        }
        for (int i1 : result) {
            System.out.println(i1);
        }
    }
    private static int solution(String[] str) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : str) {
            String[] split = s.split(" ");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

        int result = 1;
        for(int count : map.values()){
            result *= count + 1;
        }

        return result -1 ;
    }
}
