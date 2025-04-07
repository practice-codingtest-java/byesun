
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어정렬1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for(int i=0; i<N; i++) {
            str[i] = br.readLine();
        }
        Arrays.sort(str, (o1,o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        System.out.println(str[0]);
        for(int i=1; i<N; i++) {
            if(!str[i].equals(str[i-1])) {
                System.out.println(str[i]);
            }
        }
    }
}