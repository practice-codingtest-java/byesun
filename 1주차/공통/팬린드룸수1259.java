// 팬린드룸수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팬린드룸수1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;
            if(extracted(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }

    private static boolean extracted(String str) {
        int start = 0;
        int end = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
                start++;
                end--;
        }
        return true;
    }
}
