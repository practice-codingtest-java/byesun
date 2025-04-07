
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 자주 나오는 단어일수록 앞에 배치한다.
 * 2. 해당 단어의 기이가 길 수록 앞에 배치한다.
 * 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.
 *  N 단어의 개수, M 외울 단어의 최소 길이
 * 
 * 정렬을 신경써야 하는 문제 2, 3은 정렬 기능 1은 따로 count를 판단 후 배치치
 */
public class 영단어암기는괴로워20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        List<String> result_list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(s.length() >= M) {
                list.add(s);
            }
        }

        for(String s : list) {
            if(!result_list.contains(s)) {
                result_list.add(s);
            }
        }

        Comparator<String> comparator = (s1,s2) -> {
            int s1_count = countWord(list,s1);
            int s2_count = countWord(list,s2);

            if(s1_count != s2_count) {
                return s2_count - s1_count;
            } else if(s1.length() != s2.length()) {
                return s2_count - s1.length();
            } else {
                return s1.compareTo(s2);
            }
        };
        Collections.sort(result_list, comparator);

        for (String s : result_list) {
            System.out.println(s);
        }
    }
        private static int countWord(List<String> list, String s) {
        int count = 0;
        for (String word : list) {
            if(word.equals(s)) {
                count++;
            }
        }
        return count;
    }
}