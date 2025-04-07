import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 숫자 배열을 내림차순으로 정렬하면 된다. reverse()을 사용하면 될거 같은데?
 */
public class 소트인사이드1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String[] split = N.split("");
        String collect = Arrays.stream(split).sorted().collect(Collectors.joining());
        StringBuilder sb = new StringBuilder();
        sb.append(collect).reverse();
        System.out.println(sb.toString());

    }
}
