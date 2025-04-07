import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열을 반시계 방향으로 돌린다.
 * 바깥쪽 레이어부터 안쪽으로 하나씩 이동?
 * 한 레이어는 위 -> 오른쪽 -> 아래 -> 왼쪽 방향으로 한 칸씩 이동동
 */
public class 배열돌리기16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<R; i++) {
            rotation_arr(arr,N,M);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(arr[i][j] + " ");
            }
        }
    }
    private static void rotation_arr(int[][] arr, int N, int M) {
        int temp = arr[0][0];

        for(int i=0; i<N-1; i++) {
            arr[0][i] = arr[0][i+1];
        }
        for(int i=0; i<M-1; i++) {
            arr[i][M-1] = arr[i+1][M-1];
        }
        for(int i=M-1; i>0; i--) {
            arr[N-1][i] = arr[N-1][i-1];
        }
        for(int i=N-1; i>1; i--) {
            arr[i][0] = arr[i-1][0];
        }
        arr[1][0] = temp;

    }
}