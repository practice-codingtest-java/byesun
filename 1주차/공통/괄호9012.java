import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 괄호9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String str = br.readLine();
            if (bracket_Judgment(str)) {
                System.out.println("Yes\n");
            } else {
                System.out.println("No\n");
            }
        }
    }
    private static boolean bracket_Judgment(String str) {
        Stack<Character> st = new Stack<>();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if(c == '(') {
                st.push('(');
            } else if(c == ')') {
                if(st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
