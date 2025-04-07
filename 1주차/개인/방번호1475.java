//방 번호
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1~9까지의 숫자 중
 * 배열을 하나씩 두고 숫자가 6과 9는 중복을 2번 허용하고 나머지 숫자들은 중복이 있을 때마다 세트가 늘어나면 된다.
 * 생각해야 하는 부분이 66999 같이 6이 2개이고, 9가 3개인 경우에는
 * 두개의 count가 총 5이다
 *  총 필요한 세트의 개수는 3개 이며, count + 1를 진행하면 될거 같다.
 */
public class 방번호1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] count = new int[10];
        for (char c : N.toCharArray()) {
            int num = c - '0';
            count[num]++;
        }

        int i1 = count[6] + count[9];
        count[9] = (i1+1)/2;
        count[6] = count[9];

        int result = 0;
        for (int i = 0; i < 9; i++) {
            if(count[i] > result) {
                result = count[i];
            }
        }
        System.out.println(result);
    }
}
