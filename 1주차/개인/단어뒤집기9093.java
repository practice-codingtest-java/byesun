package codingTestStudy.before;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 단어뒤집기9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] words = br.readLine().split(" ");

            for (String word : words) {
                StringBuilder sb = new StringBuilder(word);
                bw.write(sb.reverse().toString() + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
