import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2s
 * 가장 많이 같은 반이었던 학생 출력
 * 만약 같은 경우 가장 작은 번호만 출력
 *
 * x축을 횟수, y축을 학생의 번호 ( + y축 배열 )
 */
// 컴파일 에러
public class 임시반장정하기1268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] student_arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < n; j++) {
                student_arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] count_arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                for (int k = 0; k < 5; k++) {
                    if(student_arr[i][k] == student_arr[j][k]) {
                        count_arr[i]++;
                        break;
                    }
                }
            }
        }
        int max_num = 0;
        int class_monitor = 0;
        for (int i = 0; i < n; i++) {
            if(count_arr[i] > max_num) {
                max_num = count_arr[i];
                class_monitor = i;
            }
        }
        System.out.println(class_monitor + 1);
    }
}
