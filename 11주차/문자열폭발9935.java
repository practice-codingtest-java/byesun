// https://www.acmicpc.net/problem/9935

import java.io.*;

/** 
 * 스택 처럼 sb를 사용하여 문자열을 집어 넣는 동시에 폭발 문자와 같다고 처리되면 
 * 바로 폭발 그리고 그 다음 글자를 넣어서 게속 검사 시켜서 게속 boom
 */
public class 문자열폭발9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        int boomLen = boom.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= boomLen) {
                boolean isSame = true;
                for (int j = 0; j < boomLen; j++) {
                    if (sb.charAt(sb.length() - boomLen + j) != boom.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    sb.delete(sb.length() - boomLen, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
