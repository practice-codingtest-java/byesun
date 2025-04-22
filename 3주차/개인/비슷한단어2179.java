// https://www.acmicpc.net/problem/2179
import java.io.*;
/**
 * 첫 번쨰 방법
 * 길이를 기준으로 정렬을 한다.
 * startsWith를 사용하기 위해서는 긴 단어를 기준으로 짧은 단어를 검사를 진행해야 접두사인지를 확인할 수 있다.
 */
public class 비슷한단어2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
//        Arrays.sort(str);  // 정렬을 진행하면 현재의 단어와 다중에 단어의 위치가 바뀜
        String s1 = "", s2 = "";
        int maxPrefixLength = 0; // 가장 접두사의 길이가 긴 변수
        for(int i=0; i<n; i++) {
            String currentWord = str[i];
            for(int j=i+1; j<n; j++) {
                String nextWord = str[j];
                int prefixLength = getPrefixLength(currentWord, nextWord); // 현재의 단어와 비교할 단어를 매개변수로
                if(prefixLength > maxPrefixLength) { // 결과의 접두사의 길이가 현재의 접두사의 길이보다 클 경우 현재의 접두사의 길이를 결과의 접두사의 길이로 반환하고,
                    // 결과 단어 변수에 현재의 단어와 새로운 단어를 넣는다.
                    maxPrefixLength = prefixLength;
                    s1 = currentWord;
                    s2 = nextWord;
                }
            }
        }
        System.out.println(s1);
        System.out.println(s2);
    }

    /**
     * 두 단어의 접두사의 길이를 반환하는 메서드
     * @param s1
     * @param s2
     * @return
     */
    private static int getPrefixLength(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length()); // 두 단어의 최소 길이를 최소
        int prefixLength = 0;
        for(int i=0; i<len; i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                prefixLength++;
            } else {
                break;
            }
        }
        return prefixLength;
    }
}
