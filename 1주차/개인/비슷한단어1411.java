
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * str[0] 의 단어가 시작점이 되어 str[index]가 될 때 까지
 *  : 단어가 숌이면
 *      count ++
 *  : 단어가 숌이 아니면
 *
 */
public class 비슷한단어1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(samePattern(str[i],str[j])) {
                count++;   
                }
            }
        }
        System.out.println(count);
    }
    private  static boolean samePattern(String s1, String s2) {
        int[] s1_arr = new int[26];
        int[] s2_arr = new int[26];
        int s1_next = 0;
        int s2_next = 0;
        for(int i=0; i<s1.length(); i++) {
            char s1_ch = s1.charAt(i);
            char s2_ch = s2.charAt(i);

            if(s1_arr[s1_ch - 'a'] == 0) {
                s1_arr[s1_ch - 'a'] = ++s1_next;
            }
            if(s2_arr[s2_ch - 'a'] == 0) {
                s2_arr[s2_ch - 'a'] = ++s2_next;
            }
            if(s1_arr[s1_ch - 'a'] != s2_arr[s2_ch -'a']) {
                return false;
            }
        }
        return true;
    }
}